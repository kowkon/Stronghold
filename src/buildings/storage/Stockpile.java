package buildings.storage;

import java.util.ArrayList;
import castle.Castle;
import items.Item;

public class Stockpile extends StorageBuilding {

	private int roomLimit;
	private ArrayList<Item> rooms;

	public Stockpile(Castle castle) {
		super(castle);
		rooms = new ArrayList<>();
		roomLimit = 4;
	}

	@Override
	public synchronized boolean addItem(Item item) {
		if (item.getAmount() <= 0)
			return false;
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass()) && i.getAmount() != i.getStackLimit()) {
				if (i.getAmount() + item.getAmount() <= i.getStackLimit()) {
					i.add(item);
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
				return true;
			}
		}
		return false;
	}

	@Override
	public synchronized boolean removeItem(Item item) {
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
			return true;
		}
	}

	private int totalAmount(Item item) {
		int total = 0;
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass())) {
				total += i.getAmount();
			}
		}
		return total;
	}

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

	private void removeZeros() {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getAmount() == 0) {
				rooms.remove(i);
			}
		}
	}

}
