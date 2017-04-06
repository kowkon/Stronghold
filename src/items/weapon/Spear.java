package items.weapon;

import items.Item;

public class Spear extends Item {

	public Spear() {
		setAmount(0);
		setStackLimit(10);
	}

	public Spear(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Spear(amount);
	}

}
