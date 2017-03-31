package buildings.farm;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Granary;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.food.Meat;

public class HuntersPost extends ProducerBuilding {

	public HuntersPost(Castle castle) {
		super(castle);
		produceAmount = 5;
		speed = 5;
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public void work() {
		while (working) {
			goToHut();
			seekHunt();
			Hunt();
			goToHut();
			chopMeat();
			goToStore();
			produce(new Meat(produceAmount));
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
		while ((granary = findProduceBuilding()) == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (!granary.addItem(item)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void goToHut() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void seekHunt() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void Hunt() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void chopMeat() {
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
