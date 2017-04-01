package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;
import items.food.Bread;

public class Granary extends StorageBuilding {

	public ArrayList<Item> rooms;

	public Granary(Castle castle) {
		super(castle);
		rooms = new ArrayList<>();
		rooms.add(new Bread());
	}

	@Override
	public boolean addItem(Item item) {
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass())) {
				if (i.getAmount() < i.getStackLimit()) {
					if (i.getAmount() + item.getAmount() > i.getStackLimit()) {
						i.setAmount(i.getStackLimit());
					} else {
						i.add(item);
					}
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeItem(Item item) {
		for (Item i : rooms) {
			if (i.getClass().equals(item.getClass())) {
				if (i.getAmount() < item.getAmount()) {
					return false;
				} else {
					i.remove(item);
					return true;
				}
			}
		}
		return false;
	}

}
