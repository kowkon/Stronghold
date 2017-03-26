package buildings;

import castle.Castle;
import materials.Material;

public abstract class ConsumerProducerBuilding extends ProducerBuilding {

	protected int consumeAmount;

	public ConsumerProducerBuilding(Castle castle) {
		super(castle);
	}

	public abstract Building findComsumeBuilding();

	public abstract void consume(Material material);

	public int getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

}
