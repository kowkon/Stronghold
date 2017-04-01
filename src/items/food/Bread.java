package items.food;

import castle.Castle;
import items.Item;

public class Bread extends Item {

	public Bread() {
		setAmount(0);
		setStackLimit(100);
	}

	public Bread(int amount) {
		setAmount(amount);
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
		return new Bread(amount);
	}

}
