package items.weapon;

import items.Item;

public class Pike extends Item {

	public Pike() {
		setAmount(0);
		setStackLimit(10);
	}

	public Pike(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Pike(amount);
	}

}
