package buildings;

import castle.Castle;
import items.Item;

public abstract class ConsumerProducerBuilding extends ProducerBuilding {

	protected int consumeAmount;

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            The castle that the building belongs
	 */
	public ConsumerProducerBuilding(Castle castle) {
		super(castle);
	}

	public abstract Building findComsumeBuilding();

	public abstract void consume(Item item);

	//GETTERS AND SETTERS
	
	public int getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

}
