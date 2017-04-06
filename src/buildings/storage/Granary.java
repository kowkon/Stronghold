package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;
import items.food.Bread;

public class Granary extends StorageBuilding {

	public static final Object addLock = new Object();
	public static final Object removeLock = new Object();

	public ArrayList<Item> rooms;

	/**
	 * Constructs a Granary.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public Granary(Castle castle) {
		super(castle);
		rooms = new ArrayList<>();
		rooms.add(new Bread());
	}

	/**
	 * Adds an item to the granary.
	 * 
	 * @param item
	 *            that will be added to the granary.
	 */
	@Override
	public boolean addItem(Item item) {
		synchronized (removeLock) {
			for (Item i : rooms) {
				if (i.getClass().equals(item.getClass())) {
					if (i.getAmount() < i.getStackLimit()) {
						if (i.getAmount() + item.getAmount() > i.getStackLimit()) {
							i.setAmount(i.getStackLimit());
						} else {
							i.add(item);
						}
						removeLock.notifyAll();
						return true;
					} else
						return false;
				}
			}
			return false;
		}
	}

	/**
	 * Removes an item from the granary.
	 * 
	 * @param item
	 *            that will be removed from the granary.
	 */
	@Override
	public boolean removeItem(Item item) {
		synchronized (addLock) {
			for (Item i : rooms) {
				if (i.getClass().equals(item.getClass())) {
					if (i.getAmount() < item.getAmount()) {
						return false;
					} else {
						i.remove(item);
						addLock.notifyAll();
						return true;
					}
				}
			}
			return false;
		}
	}

}
