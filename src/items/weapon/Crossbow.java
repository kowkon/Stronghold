package items.weapon;

import items.Item;

public class Crossbow extends Item {

	public Crossbow() {
		setAmount(0);
		setStackLimit(10);
	}

	public Crossbow(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Crossbow(amount);
	}

}
