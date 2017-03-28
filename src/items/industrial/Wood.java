package items.industrial;

import castle.Castle;
import items.Item;

public class Wood extends Item {

	/**
	 * Constructs a wood object with the specified amount.
	 * 
	 * @param amount
	 *            Amount of wood
	 */
	public Wood(int amount) {
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
		return new Wood(amount);
	}

}
