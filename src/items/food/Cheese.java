package items.food;

import items.Item;

public class Cheese extends Item {

	public Cheese() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Cheese(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Cheese(amount);
	}

}
