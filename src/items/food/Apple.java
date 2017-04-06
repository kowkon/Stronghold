package items.food;

import items.Item;

public class Apple extends Item {

	/**
	 * Constructs an Apple with default amount 0.
	 */
	public Apple() {
		setAmount(0);
		setStackLimit(100);
	}

	/**
	 * Constructs an Apple with given amount.
	 * 
	 * @param amount
	 *            Given amount for the Apple.
	 */
	public Apple(int amount) {
		this.amount = amount;
		setStackLimit(100);
	}

	@Override
	public Item create(int amount) {
		return new Apple(amount);
	}

}
