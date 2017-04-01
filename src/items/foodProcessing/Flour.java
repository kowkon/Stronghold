package items.foodProcessing;

import castle.Castle;
import items.Item;

public class Flour extends Item {

	public Flour() {
		setAmount(0);
		setStackLimit(40);
	}

	public Flour(int amount) {
		setAmount(amount);
		setStackLimit(40);
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
		return new Flour(amount);
	}

}
