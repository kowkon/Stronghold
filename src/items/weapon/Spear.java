package items.weapon;

import items.Item;

public class Spear extends Item {

	public Spear() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Spear(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Spear(amount);
	}

}
