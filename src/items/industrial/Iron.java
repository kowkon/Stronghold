package items.industrial;

import items.Item;

public class Iron extends Item {

	/**
	 * Constructs an Iron with default amount 0.
	 */
	public Iron() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	/**
	 * Constructs an Iron with the specified amount.
	 * 
	 * @param amount
	 *            Amount of iron
	 */
	public Iron(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Iron(amount);
	}

}
