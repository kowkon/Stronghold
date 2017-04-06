package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;

public class Armory extends StorageBuilding {

	public static final Object addLock = new Object();
	public static final Object removeLock = new Object();

	private int roomLimit;
	private ArrayList<Item> rooms;

	/**
	 * Constructs an Armory.
	 * 
	 * @param castle
	 *            that the building belong to.
	 */
	public Armory(Castle castle) {
		super(castle);
		rooms = new ArrayList<>();
		roomLimit = 4;
	}

	/**
	 * Adds an item to Armory.
	 * 
	 * @param item
	 *            that will be added to the Armory.
	 */
	@Override
	public boolean addItem(Item item) {
		synchronized (removeLock) {
			if (item.getAmount() <= 0)
				return false;
			for (Item i : rooms) {
				if (i.getClass().equals(item.getClass()) && i.getAmount() != i.getStackLimit()) {
					if (i.getAmount() + item.getAmount() <= i.getStackLimit()) {
						i.add(item);
						removeLock.notifyAll();
						return true;
					} else {
						item.setAmount(item.getAmount() + i.getAmount() - i.getStackLimit());
						i.setAmount(i.getStackLimit());
						addItem(item);
						return true;
					}
				}
			}
			if (rooms.size() < roomLimit) {
				if (item.getAmount() > item.getStackLimit()) {
					Item out = item.create(item.getAmount() - item.getStackLimit());
					item.setAmount(item.getStackLimit());
					rooms.add(item);
					addItem(out);
					return true;
				} else {
					rooms.add(item);
					removeLock.notifyAll();
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Removes an item from the Armory.
	 * 
	 * @param item
	 *            that will be removed from the Armory.
	 */
	@Override
	public boolean removeItem(Item item) {
		synchronized (addLock) {
			if (item.getAmount() <= 0)
				return false;
			if (totalAmount(item) < item.getAmount())
				return false;
			else {
				Item min = findMin(item);
				if (item.getAmount() > min.getAmount()) {
					Item out = item.create(item.getAmount() - min.getAmount());
					min.setAmount(0);
					removeZeros();
					removeItem(out);
				} else {
					min.remove(item);
					removeZeros();
				}
				addLock.notifyAll();
				return true;
			}
		}
	}

	/**
	 * Calculates the total amount of an item.
	 * 
	 * @param item
	 *            that its total amount will be calculated.
	 * @return total amount of given item.
	 */
	private int totalAmount(Item item) {
		int total = 0;
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass())) {
				total += i.getAmount();
			}
		}
		return total;
	}

	/**
	 * Finds the item with minimum amount.
	 * 
	 * @param item
	 *            that will be sought.
	 * @return The item with the minimum amount.
	 */
	private Item findMin(Item item) {
		Item min = null;
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass())) {
				if (min == null)
					min = i;
				else if (i.getAmount() < min.getAmount())
					min = i;
			}
		}
		return min;
	}

	/**
	 * Removes items with amount 0 or less.
	 */
	private void removeZeros() {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getAmount() <= 0) {
				rooms.remove(i);
			}
		}
	}

}
