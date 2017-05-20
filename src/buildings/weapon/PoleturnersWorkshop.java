package buildings.weapon;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Armory;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.industrial.Wood;
import items.weapon.Pike;
import items.weapon.Spear;

public class PoleturnersWorkshop extends ProducerConsumerBuilding {

	public boolean produceType;

	public PoleturnersWorkshop(Castle castle) {
		super(castle);
		produceAmount = findProduceAmount();
		consumeAmount = findConsumeAmount();
		speed = castle.getSpeed();
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

	private Item findProduceItem() {
		Item produceItem = null;
		if (produceType)
			produceItem = new Spear(produceAmount);
		else
			produceItem = new Pike(produceAmount);
		return produceItem;
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
