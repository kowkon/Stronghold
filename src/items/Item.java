package items;

import castle.Castle;

public abstract class Item {

	protected int amount;
	protected int stackLimit;

	/**
	 * Constructs an Item with default amount 0.
	 */
	public Item() {
		setAmount(0);
	}

	/**
	 * Constructs an Item with given amount.
	 * 
	 * @param amount
	 *            Given amount for the item.
	 */
	public Item(int amount) {
		setAmount(amount);
	}

	public abstract void invokeBuildingsAdd(Castle castle);

	public abstract void invokeBuildingsRemove(Castle castle);

	public abstract Item create(int amount);

	/**
	 * Sums this class' amount and given item's amount.
	 * 
	 * @param item
	 *            that will be summed up.
	 * @return This item with summed up amount.
	 */
	public Item add(Item item) {
		this.amount += item.amount;
		return this;
	}

	/**
	 * Subtracts this class's amount and given item's amount.
	 * 
	 * @param item
	 *            that will be subtracted.
	 * @return This item with subtracted amount.
	 */
	public Item remove(Item item) {
		this.amount -= item.amount;
		return this;
	}

	// GETTERS AND SETTERS

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount >= 0) // check if amount is non-negative
			this.amount = amount;
		else
			this.amount = 0;
	}

	public int getStackLimit() {
		return stackLimit;
	}

	public void setStackLimit(int stackLimit) {
		this.stackLimit = stackLimit;
	}

}
