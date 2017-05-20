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
		stacks = getStacks();
		produceAmount = findProduceAmount();
		consumeAmount = findConsumeAmount();
		speed = 10;
		this.start();
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
