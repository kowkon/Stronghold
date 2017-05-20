package items.weapon;

import items.Item;

public class Mace extends Item {

	public Mace() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Mace(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Mace(amount);
	}

}
