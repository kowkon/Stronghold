package items.weapon;

import items.Item;

public class MetalArmor extends Item {

	public MetalArmor() {
		setAmount(0);
		setStackLimit(10);
	}

	public MetalArmor(int amount) {
		setAmount(amount);
		setStackLimit(10);
	}

	@Override
	public Item create(int amount) {
		return new MetalArmor(amount);
	}

}
