package buildings.farm;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Granary;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.food.Apple;

public class AppleOrchard extends ProducerBuilding {

	/**
	 * Constructs an AppleOrchard.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public AppleOrchard(Castle castle) {
		super(castle);
		produceAmount = findProduceAmount();
		speed = castle.getSpeed();
		this.start();
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public void work() {
		while (working) {
			goToOrchard();
			plantTrees();
			growTrees();
			harvest();
			goToStore();
			produce(new Apple(produceAmount));
		}
	}

	@Override
	public StorageBuilding findProduceBuilding() {
		StorageBuilding granary = null;
		for (Building b : castle.getBuildings()) {
			if (b instanceof Granary) {
				granary = (Granary) b;
			}
		}
		return granary;
	}

	private void goToOrchard() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void plantTrees() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void growTrees() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void harvest() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void goToStore() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
