package buildings.storage;

import castle.Castle;
import items.Item;

public class Stack extends StorageBuilding {

	private int stackAmount;
	private Item storedItem;

	/**
	 * Constructs a stack that only stores specified item.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 * @param item
	 *            that will be stored in this stack.
	 */
	public Stack(Castle castle, Item storedItem) {
		super(castle);
		this.storedItem = storedItem;
		stackAmount = 0;
	}

	/**
	 * Adds the item to the stack.
	 * 
	 * @param item
	 *            that will be added to the stack.
	 * 
	 * @return true if item can be added, false otherwise.
	 */
	@Override
	public synchronized boolean addItem(Item item) {
		if (!this.storedItem.getClass().equals(item.getClass()))
			return false;
		if (stackAmount <= this.storedItem.getStackLimit()) {
			if (stackAmount + item.getAmount() > this.storedItem.getStackLimit()) {
				stackAmount = item.getStackLimit();
			} else {
				stackAmount += item.getAmount();
			}
			return true;
		}
		return false;
	}

	/**
	 * Removes the item from the stack.
	 * 
	 * @param item
	 *            that will be removed from the stack.
	 * 
	 * @return true if item can be removed, false otherwise.
	 */
	@Override
	public synchronized boolean removeItem(Item item) {
		if (!this.storedItem.getClass().equals(item.getClass()))
			return false;
		if (stackAmount < item.getAmount())
			return false;
		stackAmount -= item.getAmount();
		return true;
	}

	public boolean isFull() {
		if (stackAmount >= storedItem.getStackLimit())
			return true;
		return false;
	}

	// GETTERS AND SETTERS

	public int getStackAmount() {
		return stackAmount;
	}

	public void setStackAmount(int stackAmount) {
		this.stackAmount = stackAmount;
	}

	public Item getStoredItem() {
		return storedItem;
	}

	public void setStoredItem(Item storedItem) {
		this.storedItem = storedItem;
	}

}
