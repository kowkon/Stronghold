package castle;

import java.util.ArrayList;
import buildings.Building;
import people.Peasant;

public class Castle extends Thread {

	private int speed;
	private int popularity;
	private int maxPopularity;
	private int population;
	private int maxPopulation;

	private ArrayList<Building> buildings;
	private ArrayList<Peasant> peasants;

	/**
	 * Constructor
	 */
	public Castle() {
		setBuildings(new ArrayList<>());
		setPeasants(new ArrayList<>());
	}

	@Override
	public void run() {

	}

	// GETTERS AND SETTERS

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getMaxPopularity() {
		return maxPopularity;
	}

	public void setMaxPopularity(int maxPopularity) {
		this.maxPopularity = maxPopularity;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getMaxPopulation() {
		return maxPopulation;
	}

	public void setMaxPopulation(int maxPopulation) {
		this.maxPopulation = maxPopulation;
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}

	public ArrayList<Peasant> getPeasants() {
		return peasants;
	}

	public void setPeasants(ArrayList<Peasant> peasants) {
		this.peasants = peasants;
	}

}
