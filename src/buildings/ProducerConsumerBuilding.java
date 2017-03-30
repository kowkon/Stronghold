package buildings;

import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;

public abstract class ProducerConsumerBuilding extends ProducerBuilding {

	protected int consumeAmount;

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            The castle that the building belongs
	 */
	public ProducerConsumerBuilding(Castle castle) {
		super(castle);
	}

	public abstract StorageBuilding findComsumeBuilding();

	public abstract void consume(Item item);

	//GETTERS AND SETTERS
	
	public int getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

}
