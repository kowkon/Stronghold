package buildings.industry;

import buildings.ProducerBuilding;
import buildings.storage.Stack;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
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
		produceAmount = 1;
		speed = 10;
		stack = new Stack(castle, new Stone());
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

	@Override
	public synchronized void produce(Item item) {
		StorageBuilding stack = findProduceBuilding();
		while (!stack.addItem(item)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
