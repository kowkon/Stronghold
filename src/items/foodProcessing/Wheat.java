package items.foodProcessing;

import castle.Castle;
import items.Item;

public class Wheat extends Item {

	public Wheat() {
		setAmount(0);
		setStackLimit(50);
	}

	public Wheat(int amount) {
		setAmount(amount);
		setStackLimit(50);
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
		return new Wheat(amount);
	}

}
