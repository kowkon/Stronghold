package buildings.industry;

import buildings.ProducerBuilding;
import buildings.storage.Stack;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.industrial.Stone;

public class Quarry extends ProducerBuilding {

	private Stack stack;

	/**
	 * Constructs a Quarry.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public Quarry(Castle castle) {
		super(castle);
		produceAmount = findProduceAmount();
		speed = castle.getSpeed();
		stack = new Stack(castle, new Stone());
		this.start();
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public void work() {
		while (working) {
			extractStone();
			shapeStone();
			produce(new Stone(produceAmount));
		}
	}

	@Override
	public StorageBuilding findProduceBuilding() {
		return stack;
	}

	private void extractStone() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void shapeStone() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// GETTERS AND SETTERS

	public Stack getStack() {
		return stack;
	}

	public void setStack(Stack stack) {
		this.stack = stack;
	}

}
