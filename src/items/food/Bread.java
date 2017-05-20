package items.food;

import items.Item;

public class Bread extends Item {

	public Bread() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Bread(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Bread(amount);
	}

}
