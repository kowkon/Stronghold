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
import items.weapon.Crossbow;

public class FletchersWorkshop extends ProducerConsumerBuilding {

	public boolean produceType;

	/**
	 * Constructs a Fletcher's Workshop.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public FletchersWorkshop(Castle castle) {
		super(castle);
		speed = 100;
		produceAmount = findProduceAmount();
		consumeAmount = findConsumeAmount();
		produceType = true;
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
			Item produceItem = findProduceItem();
			goToWorkshop();
			consumeAll();
			produce(produceItem);
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

	private Item findProduceItem() {
		Item produceItem = null;
		if (produceType)
			produceItem = new Bow(produceAmount);
		else
			produceItem = new Crossbow(produceAmount);
		return produceItem;
	}

}
