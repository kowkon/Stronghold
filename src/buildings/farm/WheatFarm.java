package buildings.farm;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.foodProcessing.Wheat;

public class WheatFarm extends ProducerBuilding {

	public WheatFarm(Castle castle) {
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
			goToFarm();
			plowField();
			growSeeds();
			mow();
			goToStore();
			produce(new Wheat(produceAmount));
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

	private void goToFarm() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void plowField() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void growSeeds() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void mow() {
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
