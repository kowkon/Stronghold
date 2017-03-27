package buildings;

import castle.Castle;
import items.Item;

public abstract class ProducerBuilding extends Building {

	protected int produceAmount;
	protected int speed;

	public ProducerBuilding(Castle castle) {
		super(castle);
	}

	public abstract void work();

	public abstract Building findProduceBuilding();

	public abstract void produce(Item material);

	public int getProduceAmount() {
		return produceAmount;
	}

	public void setProduceAmount(int produceAmount) {
		this.produceAmount = produceAmount;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
