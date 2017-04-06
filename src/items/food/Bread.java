package items.food;

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
	public Item create(int amount) {
		return new Bread(amount);
	}

}
