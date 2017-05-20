package buildings.storage;

import java.util.ArrayList;

import castle.Castle;
import items.Item;
import items.weapon.Bow;
import items.weapon.Crossbow;
import items.weapon.LeatherArmor;
import items.weapon.Mace;
import items.weapon.MetalArmor;
import items.weapon.Pike;
import items.weapon.Spear;
import items.weapon.Sword;
import ui.textFields.DisplayObserver;

public class Armory extends StorageBuilding implements IArmory {

	private int roomLimit;
	public ArrayList<Item> rooms;

	private ArrayList<DisplayObserver> bowObservers;
	private ArrayList<DisplayObserver> crossbowObservers;
	private ArrayList<DisplayObserver> leatherArmorObservers;
	private ArrayList<DisplayObserver> maceObservers;
	private ArrayList<DisplayObserver> metalArmorObservers;
	private ArrayList<DisplayObserver> pikeObservers;
	private ArrayList<DisplayObserver> spearObservers;
	private ArrayList<DisplayObserver> swordObservers;

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

		bowObservers = new ArrayList<>();
		crossbowObservers = new ArrayList<>();
		leatherArmorObservers = new ArrayList<>();
		maceObservers = new ArrayList<>();
		metalArmorObservers = new ArrayList<>();
		pikeObservers = new ArrayList<>();
		spearObservers = new ArrayList<>();
		swordObservers = new ArrayList<>();
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
						if (item instanceof Bow) {
							notifyObservers(bow);
						} else if (item instanceof Crossbow) {
							notifyObservers(crossbow);
						} else if (item instanceof LeatherArmor) {
							notifyObservers(leatherArmor);
						} else if (item instanceof Mace) {
							notifyObservers(mace);
						} else if (item instanceof MetalArmor) {
							notifyObservers(metalArmor);
						} else if (item instanceof Pike) {
							notifyObservers(pike);
						} else if (item instanceof Spear) {
							notifyObservers(spear);
						} else if (item instanceof Sword) {
							notifyObservers(sword);
						}
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
					if (item instanceof Bow) {
						notifyObservers(bow);
					} else if (item instanceof Crossbow) {
						notifyObservers(crossbow);
					} else if (item instanceof LeatherArmor) {
						notifyObservers(leatherArmor);
					} else if (item instanceof Mace) {
						notifyObservers(mace);
					} else if (item instanceof MetalArmor) {
						notifyObservers(metalArmor);
					} else if (item instanceof Pike) {
						notifyObservers(pike);
					} else if (item instanceof Spear) {
						notifyObservers(spear);
					} else if (item instanceof Sword) {
						notifyObservers(sword);
					}
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
				if (item instanceof Bow) {
					notifyObservers(bow);
				} else if (item instanceof Crossbow) {
					notifyObservers(crossbow);
				} else if (item instanceof LeatherArmor) {
					notifyObservers(leatherArmor);
				} else if (item instanceof Mace) {
					notifyObservers(mace);
				} else if (item instanceof MetalArmor) {
					notifyObservers(metalArmor);
				} else if (item instanceof Pike) {
					notifyObservers(pike);
				} else if (item instanceof Spear) {
					notifyObservers(spear);
				} else if (item instanceof Sword) {
					notifyObservers(sword);
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

	private int bowAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Bow)
				total += i.getAmount();
		}
		return total;
	}

	private int crossbowAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Crossbow)
				total += i.getAmount();
		}
		return total;
	}

	private int leatherArmorAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof LeatherArmor)
				total += i.getAmount();
		}
		return total;
	}

	private int maceAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Mace)
				total += i.getAmount();
		}
		return total;
	}

	private int metalArmorAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof MetalArmor)
				total += i.getAmount();
		}
		return total;
	}

	private int pikeAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Pike)
				total += i.getAmount();
		}
		return total;
	}

	private int spearAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Spear)
				total += i.getAmount();
		}
		return total;
	}

	private int swordAmount() {
		int total = 0;
		for (Item i : rooms) {
			if (i instanceof Sword)
				total += i.getAmount();
		}
		return total;
	}

	@Override
	public void register(DisplayObserver displayObserver, int type) {

		switch (type) {
		case bow:
			bowObservers.add(displayObserver);
			notifyObservers(bow);
			break;
		case crossbow:
			crossbowObservers.add(displayObserver);
			notifyObservers(crossbow);
			break;
		case leatherArmor:
			leatherArmorObservers.add(displayObserver);
			notifyObservers(leatherArmor);
			break;
		case mace:
			maceObservers.add(displayObserver);
			notifyObservers(mace);
			break;
		case metalArmor:
			metalArmorObservers.add(displayObserver);
			notifyObservers(metalArmor);
			break;
		case pike:
			pikeObservers.add(displayObserver);
			notifyObservers(pike);
			break;
		case spear:
			spearObservers.add(displayObserver);
			notifyObservers(spear);
			break;
		case sword:
			swordObservers.add(displayObserver);
			notifyObservers(sword);
			break;
		}

	}

	@Override
	public void unregister(DisplayObserver displayObserver, int type) {

	}

	@Override
	public void notifyObservers(int type) {
		switch (type) {
		case bow:
			for (DisplayObserver d : bowObservers) {
				d.update(bowAmount());
			}
			break;
		case crossbow:
			for (DisplayObserver d : crossbowObservers) {
				d.update(crossbowAmount());
			}
			break;
		case leatherArmor:
			for (DisplayObserver d : leatherArmorObservers) {
				d.update(leatherArmorAmount());
			}
			break;
		case mace:
			for (DisplayObserver d : maceObservers) {
				d.update(maceAmount());
			}
			break;
		case metalArmor:
			for (DisplayObserver d : metalArmorObservers) {
				d.update(metalArmorAmount());
			}
			break;
		case pike:
			for (DisplayObserver d : pikeObservers) {
				d.update(pikeAmount());
			}
			break;
		case spear:
			for (DisplayObserver d : spearObservers) {
				d.update(spearAmount());
			}
			break;
		case sword:
			for (DisplayObserver d : swordObservers) {
				d.update(swordAmount());
			}
			break;
		}
	}

}
