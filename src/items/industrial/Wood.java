package items.industrial;

import items.Item;

public class Wood extends Item {

	/**
	 * Constructs a Wood with default amount 0.
	 */
	public Wood() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	/**
	 * Constructs a Wood with the specified amount.
	 * 
	 * @param amount
	 *            Amount of wood
	 */
	public Wood(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Wood(amount);
	}

}
