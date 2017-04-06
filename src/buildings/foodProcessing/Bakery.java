package buildings.foodProcessing;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Granary;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.food.Bread;
import items.foodProcessing.Flour;

public class Bakery extends ProducerConsumerBuilding {

	public Bakery(Castle castle) {
		super(castle);
		produceAmount = 10;
		consumeAmount = 1;
		speed = 600;
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
			goToBakery();
			goToStore();
			consume(new Flour(consumeAmount));
			goToBakery();
			cookBread();
			goToStore();
			produce(new Bread(produceAmount));
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

	@Override
	public void produce(Item item) {
		StorageBuilding granary;
		synchronized (noBuildingLock) {
			while ((granary = findProduceBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Granary.addLock) {
			while (!granary.addItem(item)) {
				try {
					Granary.addLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void goToBakery() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void cookBread() {
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
