package items.weapon;

import items.Item;

public class LeatherArmor extends Item {

	public LeatherArmor() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public LeatherArmor(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new LeatherArmor(amount);
	}

}
