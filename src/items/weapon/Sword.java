package items.weapon;

import items.Item;

public class Sword extends Item {

	public Sword() {
		setAmount(0);
		setStackLimit(10);
	}

	public Sword(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Sword(amount);
	}

}
