package buildings.foodProcessing;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.foodProcessing.Flour;
import items.foodProcessing.Wheat;

public class Mill extends ProducerConsumerBuilding {

	public Mill(Castle castle) {
		super(castle);
		produceAmount = findConsumeAmount();
		consumeAmount = findProduceAmount();
		speed = castle.getSpeed();
		this.start();
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
