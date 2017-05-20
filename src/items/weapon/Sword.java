package items.weapon;

import items.Item;

public class Sword extends Item {

	public Sword() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Sword(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Sword(amount);
	}

}
