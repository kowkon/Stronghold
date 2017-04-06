package items.foodProcessing;

import items.Item;

public class Flour extends Item {

	public Flour() {
		setAmount(0);
		setStackLimit(40);
	}

	public Flour(int amount) {
		setAmount(amount);
		setStackLimit(40);
	}

	@Override
	public Item create(int amount) {
		return new Flour(amount);
	}

}
