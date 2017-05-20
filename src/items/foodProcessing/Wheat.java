package items.foodProcessing;

import items.Item;

public class Wheat extends Item {

	public Wheat() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Wheat(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Wheat(amount);
	}

}
