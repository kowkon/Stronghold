package items.weapon;

import items.Item;

public class Pike extends Item {

	public Pike() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Pike(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Pike(amount);
	}

}
