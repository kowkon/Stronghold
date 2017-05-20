package items.foodProcessing;

import items.Item;

public class Flour extends Item {

	public Flour() {
		setAmount(0);
		setStackLimit(findStackLimit());
	}

	public Flour(int amount) {
		setAmount(amount);
		setStackLimit(findStackLimit());
	}

	@Override
	public Item create(int amount) {
		return new Flour(amount);
	}

}
