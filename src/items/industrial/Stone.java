package items.industrial;

import items.Item;

public class Stone extends Item {

	/**
	 * Constructs a Stone with default amount 0.
	 */
	public Stone() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	/**
	 * Constructs a Stone with the specified amount.
	 * 
	 * @param amount
	 *            Amount of stone
	 */
	public Stone(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Stone(amount);
	}

}
