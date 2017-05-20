package items.weapon;

import items.Item;

public class MetalArmor extends Item {

	public MetalArmor() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public MetalArmor(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new MetalArmor(amount);
	}

}
