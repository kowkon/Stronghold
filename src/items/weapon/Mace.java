package items.weapon;

import items.Item;

public class Mace extends Item {

	public Mace() {
		setAmount(0);
		setStackLimit(10);
	}

	public Mace(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new Mace(amount);
	}

}
