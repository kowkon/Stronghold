package items.weapon;

import items.Item;

public class Bow extends Item {

	public Bow() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Bow(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Bow(amount);
	}

}
