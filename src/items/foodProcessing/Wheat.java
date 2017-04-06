package items.foodProcessing;

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
	public Item create(int amount) {
		return new Wheat(amount);
	}

}
