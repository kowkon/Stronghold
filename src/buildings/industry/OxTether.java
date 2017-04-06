package buildings.industry;

import java.util.ArrayList;

import buildings.Building;
import buildings.ProducerConsumerBuilding;
import buildings.storage.Stack;
import buildings.storage.Stockpile;
import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;
import items.industrial.Stone;

public class OxTether extends ProducerConsumerBuilding {

	private Item carryItem;
	private ArrayList<Stack> stacks;

	/**
	 * Constructs an OxTether.
	 * 
	 * @param castle
	 *            that the building belongs to.
	 * @param item
	 *            that OxTether will carry.
	 */
	public OxTether(Castle castle, Item item) {
		super(castle);
		carryItem = item;
		consumeAmount = 5;
		produceAmount = 8;
		speed = 100;
	}

	@Override
	public void run() {
		work();
	}

	@Override
	public StorageBuilding findComsumeBuilding() {
		StorageBuilding stack = null;
		for (Stack s : stacks) {
			if (!s.isEmpty()) {
				stack = s;
				break;
			}
		}
		return stack;
	}

	@Override
	public void consume(Item item) {
		StorageBuilding stack;
		synchronized (noBuildingLock) {
			while ((stacks = getStacks()).size() == 0) {
				try {
					System.out.println("no building");
					Building.noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Stack.removeLock) {
			while ((stack = findComsumeBuilding()) == null) {
				try {
					System.out.println("waiting");
					Stack.removeLock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			stack.removeItem(item);
		}
	}

	@Override
	public void work() {
		while (working) {
			goToBuilding();
			consumeAll();
			produce(new Stone(produceAmount));
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

	@Override
	public void produce(Item item) {
		StorageBuilding stockpile;
		synchronized (noBuildingLock) {
			while ((stockpile = findProduceBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (Stockpile.addLock) {
			while (!stockpile.addItem(item)) {
				try {
					Stockpile.addLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void goToBuilding() {
		try {
			Thread.sleep(speed * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void consumeAll() {
		int totalConsumed = 0;
		while (totalConsumed < produceAmount) {
			consume(carryItem.create(1));
			totalConsumed++;
			System.out.println("consumed" + totalConsumed);
		}
	}

	private ArrayList<Stack> getStacks() {
		stacks = new ArrayList<>();
		for (Building b : castle.getBuildings()) {
			if (b instanceof Stack && ((Stack) b).getStoredItem().getClass().equals(carryItem.getClass())) {
				stacks.add((Stack) b);
			}
		}
		return stacks;
	}

}
