package buildings.weapon;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Armory;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.industrial.Iron;
import items.weapon.Mace;
import items.weapon.Sword;

public class BlacksmithsWorkshop extends ProducerConsumerBuilding {

	public boolean produceType;

	public BlacksmithsWorkshop(Castle castle) {
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
			consume(new Iron(consumeAmount));
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
			produceItem = new Sword(produceAmount);
		else
			produceItem = new Mace(produceAmount);
		return produceItem;
	}
}
