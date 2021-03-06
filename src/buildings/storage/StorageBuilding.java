package buildings.storage;

import buildings.Building;
import castle.Castle;
import items.Item;

public abstract class StorageBuilding extends Building {

	public final Object addLock = new Object();
	public final Object removeLock = new Object();

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            that the building belongs to.
	 */
	public StorageBuilding(Castle castle) {
		super(castle);
	}

	public abstract boolean addItem(Item item);

	public abstract boolean removeItem(Item item);

}
