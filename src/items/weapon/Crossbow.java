package items.weapon;

import items.Item;

public class Crossbow extends Item {

	public Crossbow() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Crossbow(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Crossbow(amount);
	}

}
