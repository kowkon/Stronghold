package items.industrial;

import castle.Castle;
import items.Item;

public class Iron extends Item {

	/**
	 * Constructs an Iron with default amount 0.
	 */
	public Iron() {
		setAmount(0);
		setStackLimit(48);
	}

	/**
	 * Constructs an Iron with the specified amount.
	 * 
	 * @param amount
	 *            Amount of iron
	 */
	public Iron(int amount) {
		setAmount(amount);
		setStackLimit(48);
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
		return new Iron(amount);
	}

}
