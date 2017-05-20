package buildings.industry;

import buildings.ProducerBuilding;
import buildings.storage.Stack;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.industrial.Iron;

public class IronMine extends ProducerBuilding {

	private Stack stack;

	/**
	 * Constructs an Ironmine.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public IronMine(Castle castle) {
		super(castle);
		produceAmount = findProduceAmount();
		speed = 5;
		stack = new Stack(castle, new Iron());
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public void work() {
		while (working) {
			extractIron();
			melt();
			produce(new Iron(produceAmount));
		}
	}

	@Override
	public StorageBuilding findProduceBuilding() {
		return stack;
	}

	private void extractIron() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void melt() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
