package buildings.foodProcessing;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.foodProcessing.Flour;
import items.foodProcessing.Wheat;

public class Mill extends ProducerConsumerBuilding {

	public Mill(Castle castle) {
		super(castle);
		produceAmount = 1;
		consumeAmount = 1;
		speed = 200;
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
			goToMill();
			goToStore();
			consume(new Wheat(consumeAmount));
			goToMill();
			grind();
			goToStore();
			produce(new Flour(produceAmount));
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

	@Override
	public void produce(Item item) {
		StorageBuilding stockpile;
		synchronized (noBuildingLock) {
			while ((stockpile = findProduceBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Stockpile.addLock) {
			while (!stockpile.addItem(item)) {
				try {
					Stockpile.addLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void goToMill() {
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

	private void grind() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
