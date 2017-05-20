package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;
import items.foodProcessing.Flour;
import items.foodProcessing.Wheat;
import items.industrial.Iron;
import items.industrial.Stone;
import items.industrial.Wood;
import ui.textFields.DisplayObserver;

public class Stockpile extends StorageBuilding implements IStockpile {

	private int roomLimit;
	public ArrayList<Item> rooms;

	private ArrayList<DisplayObserver> woodObservers;
	private ArrayList<DisplayObserver> stoneObservers;
	private ArrayList<DisplayObserver> ironObservers;
	private ArrayList<DisplayObserver> wheatObservers;
	private ArrayList<DisplayObserver> flourObservers;

	/**
	 * Constructs a Stockpile.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public Stockpile(Castle castle) {
		super(castle);
		woodObservers = new ArrayList<>();
		stoneObservers = new ArrayList<>();
		ironObservers = new ArrayList<>();
		wheatObservers = new ArrayList<>();
		flourObservers = new ArrayList<>();
		rooms = new ArrayList<>();
		roomLimit = 4;
	}

	/**
	 * Adds an item to the stockpile.
	 * 
	 * @param item
	 *            that will be added to the stockpile.
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
						if (item instanceof Wood)
							notifyObservers(wood);
						else if (item instanceof Stone)
							notifyObservers(stone);
						else if (item instanceof Iron)
							notifyObservers(iron);
						else if (item instanceof Wheat)
							notifyObservers(wheat);
						else if (item instanceof Flour) {
							notifyObservers(flour);
						}
						return true;
					} else {
						item.setAmount(item.getAmount() + i.getAmount() - i.getStackLimit());
						i.setAmount(i.getStackLimit());
						addItem(item);
						if (item instanceof Wood)
							notifyObservers(wood);
						else if (item instanceof Stone)
							notifyObservers(stone);
						else if (item instanceof Iron)
							notifyObservers(iron);
						else if (item instanceof Wheat)
							notifyObservers(wheat);
						else if (item instanceof Flour) {
							notifyObservers(flour);
						}
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
					if (item instanceof Wood)
						notifyObservers(wood);
					else if (item instanceof Stone)
						notifyObservers(stone);
					else if (item instanceof Iron)
						notifyObservers(iron);
					else if (item instanceof Wheat)
						notifyObservers(wheat);
					else if (item instanceof Flour) {
						notifyObservers(flour);
					}
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Removes an item from the stockpile.
	 * 
	 * @param item
	 *            that will be removed from the stockpile.
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
				if (item instanceof Wood)
					notifyObservers(wood);
				else if (item instanceof Stone)
					notifyObservers(stone);
				else if (item instanceof Iron)
					notifyObservers(iron);
				else if (item instanceof Wheat)
					notifyObservers(wheat);
				else if (item instanceof Flour) {
					notifyObservers(flour);
				}
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

	private int woodAmount() {
		int sum = 0;
		for (Item i : rooms) {
			if (i instanceof Wood) {
				sum += i.getAmount();
			}
		}
		return sum;
	}

	private int stoneAmount() {
		int sum = 0;
		for (Item i : rooms) {
			if (i instanceof Stone) {
				sum += i.getAmount();
			}
		}
		return sum;
	}

	private int ironAmount() {
		int sum = 0;
		for (Item i : rooms) {
			if (i instanceof Iron) {
				sum += i.getAmount();
			}
		}
		return sum;
	}

	private int wheatAmount() {
		int sum = 0;
		for (Item i : rooms) {
			if (i instanceof Wheat) {
				sum += i.getAmount();
			}
		}
		return sum;
	}

	private int flourAmount() {
		int sum = 0;
		for (Item i : rooms) {
			if (i instanceof Flour) {
				sum += i.getAmount();
			}
		}
		return sum;
	}

	@Override
	public void register(DisplayObserver displayObserver, int type) {

		switch (type) {
		case wood:
			woodObservers.add(displayObserver);
			notifyObservers(wood);
			break;
		case stone:
			stoneObservers.add(displayObserver);
			notifyObservers(stone);
			break;
		case iron:
			ironObservers.add(displayObserver);
			notifyObservers(iron);
			break;
		case wheat:
			wheatObservers.add(displayObserver);
			notifyObservers(wheat);
			break;
		case flour:
			flourObservers.add(displayObserver);
			notifyObservers(flour);
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
		case wood:
			for (DisplayObserver d : woodObservers) {
				d.update(woodAmount());
			}
			break;
		case stone:
			for (DisplayObserver d : stoneObservers) {
				d.update(stoneAmount());
			}
			break;
		case iron:
			for (DisplayObserver d : ironObservers) {
				d.update(ironAmount());
			}
			break;
		case wheat:
			for (DisplayObserver d : wheatObservers) {
				d.update(wheatAmount());
			}
			break;
		case flour:
			for (DisplayObserver d : flourObservers) {
				d.update(flourAmount());
			}
			break;
		}
	}

}
