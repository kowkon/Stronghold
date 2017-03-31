package buildings.farm;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Granary;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.food.Apple;

public class AppleOrchard extends ProducerBuilding {

	public AppleOrchard(Castle castle) {
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
			goToOrchard();
			plantTrees();
			growTrees();
			harvest();
			goToStore();
			produce(new Apple(produceAmount));
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
	public synchronized void produce(Item item) {
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

	private void goToOrchard() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void plantTrees() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void growTrees() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void harvest() {
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
