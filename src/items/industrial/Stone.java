package items.industrial;

import castle.Castle;
import items.Item;

public class Stone extends Item {

	/**
	 * Constructs a Stone with default amount 0.
	 */
	public Stone() {
		setAmount(0);
		setStackLimit(48);
	}

	/**
	 * Constructs a Stone with the specified amount.
	 * 
	 * @param amount
	 *            Amount of stone
	 */
	public Stone(int amount) {
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
		return new Stone(amount);
	}

}
