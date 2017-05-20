package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;
import items.food.Apple;
import items.food.Bread;
import items.food.Cheese;
import items.food.Meat;
import ui.textFields.DisplayObserver;

public class Granary extends StorageBuilding implements IGranary {

	public ArrayList<Item> rooms;

	private ArrayList<DisplayObserver> meatObservers;
	private ArrayList<DisplayObserver> breadObservers;
	private ArrayList<DisplayObserver> cheeseObservers;
	private ArrayList<DisplayObserver> appleObservers;

	/**
	 * Constructs a Granary.
	 * 
	 * @param castle
	 *            that the building belongs to.x
	 */
	public Granary(Castle castle) {
		super(castle);
		
		rooms = new ArrayList<>();
		
		rooms.add(new Bread());
		rooms.add(new Meat());
		rooms.add(new Apple());
		rooms.add(new Cheese());
		
		meatObservers = new ArrayList<>();
		breadObservers = new ArrayList<>();
		cheeseObservers = new ArrayList<>();
		appleObservers = new ArrayList<>();
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
						if (item instanceof Bread) {
							notifyObservers(bread);
						} else if (item instanceof Apple) {
							notifyObservers(apple);
						} else if (item instanceof Cheese) {
							notifyObservers(cheese);
						} else if (item instanceof Meat) {
							notifyObservers(meat);
						}
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
						if (item instanceof Bread) {
							notifyObservers(bread);
						} else if (item instanceof Apple) {
							notifyObservers(apple);
						} else if (item instanceof Cheese) {
							notifyObservers(cheese);
						} else if (item instanceof Meat) {
							notifyObservers(meat);
						}
						return true;
					}
				}
			}
			return false;
		}
	}

	private int breadAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Bread)
				total += i.getAmount();
		}
		return total;
	}

	private int appleAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Apple)
				total += i.getAmount();
		}
		return total;
	}

	private int cheeseAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Cheese)
				total += i.getAmount();
		}
		return total;
	}

	private int meatAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Meat)
				total += i.getAmount();
		}
		return total;
	}

	@Override
	public void register(DisplayObserver displayObserver, int type) {

		switch (type) {
		case meat:
			meatObservers.add(displayObserver);
			notifyObservers(meat);
			break;
		case bread:
			breadObservers.add(displayObserver);
			notifyObservers(bread);
			break;
		case apple:
			appleObservers.add(displayObserver);
			notifyObservers(apple);
			break;
		case cheese:
			cheeseObservers.add(displayObserver);
			notifyObservers(cheese);
			break;
		}

	}

	@Override
	public void unregister(DisplayObserver displayObserver, int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers(int type) {

		switch (type) {
		case meat:
			for (DisplayObserver d : meatObservers) {
				d.update(meatAmount());
			}
			break;
		case bread:
			for (DisplayObserver d : breadObservers) {
				d.update(breadAmount());
			}
			break;
		case apple:
			for (DisplayObserver d : appleObservers) {
				d.update(appleAmount());
			}
			break;
		case cheese:
			for (DisplayObserver d : cheeseObservers) {
				d.update(cheeseAmount());
			}
			break;
		}

	}

}
