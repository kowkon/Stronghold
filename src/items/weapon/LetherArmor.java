package items.weapon;

import items.Item;

public class LetherArmor extends Item {

	public LetherArmor() {
		setAmount(0);
		setStackLimit(10);
	}

	public LetherArmor(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new LetherArmor(amount);
	}

}
