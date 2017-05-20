package castle;

import java.util.ArrayList;

import buildings.Building;
import buildings.ProducerBuilding;
import buildings.storage.Granary;
import items.food.Apple;
import people.Peasant;
import people.PeasantGenerator;

public class Castle extends Thread implements ICastle {

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
		popularity = 100;
		maxPopularity = 100;
		population = 0;
		maxPopulation = 8;
		speed = 100;
		PeasantGenerator pg = new PeasantGenerator(this);
		pg.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(speed * 50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Granary granary;
			if ((granary = findGranary()) == null) {
				setPopularity(getPopularity() - 2);
			} else {
				if (!granary.removeItem(new Apple(3))) {
					setPopularity(getPopularity() - 2);
				} else {
					setPopularity(getPopularity() + 2);
				}
			}
		}
	}

	public void addBuilding(Building b) {
		buildings.add(b);
	}

	private Granary findGranary() {
		Granary granary = null;
		for (Building b : buildings) {
			if (b instanceof Granary) {
				granary = (Granary) b;
				break;
			}
		}
		return granary;
	}

	@Override
	public void register(Building building) {
		buildings.add(building);
	}

	@Override
	public void unregister(Building building) {
		buildings.remove(building);
	}

	@Override
	public void notifyBuildings() {
		for (Building b : buildings) {
			if (b instanceof ProducerBuilding)
				((ProducerBuilding) b).updateSpeed(this.speed);
		}
	}

	// GETTERS AND SETTERS

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		notifyBuildings();
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		if (popularity > 100)
			this.popularity = 100;
		else if (popularity < 0)
			this.popularity = 0;
		else {
			this.popularity = popularity;
		}
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
