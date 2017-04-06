package items.weapon;

import items.Item;

public class Bow extends Item {

	public Bow() {
		setAmount(0);
		setStackLimit(10);
	}

	public Bow(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Bow(amount);
	}

}
