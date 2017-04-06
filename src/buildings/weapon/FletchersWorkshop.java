package buildings.weapon;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Armory;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.industrial.Wood;
import items.weapon.Bow;

public class FletchersWorkshop extends ProducerConsumerBuilding {

	/**
	 * Constructs a Fletcher's Workshop.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public FletchersWorkshop(Castle castle) {
		super(castle);
		speed = 100;
		consumeAmount = 2;
		produceAmount = 1;
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public StorageBuilding findComsumeBuilding() {
		StorageBuilding stockpile = null;
		for (Building b : castle.getBuildings()) {
			if (b instanceof Stockpile) {
				stockpile = (Stockpile) b;
			}
		}
		return stockpile;
	}

	@Override
	public void consume(Item item) {
		StorageBuilding stockpile;
		synchronized (noBuildingLock) {
			while ((stockpile = findComsumeBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Stockpile.removeLock) {
			while (!stockpile.removeItem(item)) {
				try {
					Stockpile.removeLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void work() {
		while (working) {
			goToWorkshop();
			consumeAll();
			produce(new Bow(1));
		}
	}

	@Override
	public StorageBuilding findProduceBuilding() {
		StorageBuilding armory = null;
		for (Building b : castle.getBuildings()) {
			if (b instanceof Armory) {
				armory = (Armory) b;
			}
		}
		return armory;
	}

	@Override
	public void produce(Item item) {
		StorageBuilding armory;
		synchronized (noBuildingLock) {
			while ((armory = findProduceBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Stockpile.addLock) {
			while (!armory.addItem(item)) {
				try {
					Stockpile.addLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void goToStore() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void goToWorkshop() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void consumeAll() {
		int totalConsumed = 0;
		while (totalConsumed < 2) {
			goToStore();
			consume(new Wood(1));
			++totalConsumed;
			goToWorkshop();
		}
	}

}
