package buildings.industry;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.industrial.Wood;

public class Woodcutter extends ProducerBuilding {

	/**
	 * Constructs a Woodcutter
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public Woodcutter(Castle castle) {
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
			goToHut();
			findTree();
			fellTree();
			chopTree();
			goToHut();
			saw();
			goToStore();
			produce(new Wood(produceAmount));
		}
	}

	@Override
	public StorageBuilding findProduceBuilding() {
		StorageBuilding stockpile = null;
		for (Building b : castle.getBuildings()) {
			if (b instanceof Stockpile) {
				stockpile = (Stockpile) b;
			}
		}
		return stockpile;
	}

	private void goToHut() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void findTree() {
		try {
			Thread.sleep(30 * speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void fellTree() {
		try {
			Thread.sleep(50 * speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void chopTree() {
		try {
			Thread.sleep(30 * speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void saw() {
		try {
			Thread.sleep(30 * speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void goToStore() {
		try {
			Thread.sleep(20 * speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
