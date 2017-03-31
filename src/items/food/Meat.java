package items.food;

import castle.Castle;
import items.Item;

public class Meat extends Item {

	/**
	 * Constructs a Meat with default amount 0.
	 */
	public Meat() {
		setAmount(0);
		setStackLimit(100);
	}

	/**
	 * Constructs a Meat with the given amount.
	 * 
	 * @param amount
	 *            Given amount for the Meat.
	 */
	public Meat(int amount) {
		this.amount = amount;
		setStackLimit(100);
	}

	@Override
	public void invokeBuildingsAdd(Castle castle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invokeBuildingsRemove(Castle castle) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item create(int amount) {
		return new Meat(amount);
	}

}
