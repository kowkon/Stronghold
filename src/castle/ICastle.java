package castle;

import buildings.Building;

public interface ICastle {
	
	public void register(Building building);
	
	public void unregister(Building building);
	
	public void notifyBuildings();

}
