package buildings.foodProcessing;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Granary;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.food.Bread;
import items.foodProcessing.Flour;

public class Bakery extends ProducerConsumerBuilding {

	public Bakery(Castle castle) {
		super(castle);
		produceAmount = findProduceAmount();
		consumeAmount = findConsumeAmount();
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
