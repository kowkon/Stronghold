package buildings;

import castle.Castle;

public class Building extends Thread {

	protected Castle castle;
	protected boolean working;

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            The castle that building belongs
	 */
	public Building(Castle castle) {
		setCastle(castle);
		setWorking(true);
	}

	// GETTERS AND SETTERS

	public Castle getCastle() {
		return castle;
	}

	public void setCastle(Castle castle) {
		this.castle = castle;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

}
