package items.food;

import items.Item;

public class Meat extends Item {

	/**
	 * Constructs a Meat with default amount 0.
	 */
	public Meat() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	/**
	 * Constructs a Meat with the given amount.
	 * 
	 * @param amount
	 *            Given amount for the Meat.
	 */
	public Meat(int amount) {
		this.amount = amount;
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Meat(amount);
	}

}
