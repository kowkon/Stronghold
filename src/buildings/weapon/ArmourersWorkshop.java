package buildings.weapon;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Armory;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.industrial.Iron;
import items.weapon.MetalArmor;

public class ArmourersWorkshop extends ProducerConsumerBuilding {

	public ArmourersWorkshop(Castle castle) {
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
			consume(new Iron(consumeAmount));
			produce(new MetalArmor(produceAmount));
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

}
