package buildings.storage;

import ui.textFields.DisplayObserver;

public interface IStockpile {
	
	public static final int wood = 1;
	public static final int stone = 2;
	public static final int iron = 3;
	public static final int wheat = 4;
	public static final int flour = 5;
	
	public void register(DisplayObserver displayObserver, int type);
	
	public void unregister(DisplayObserver displayObserver, int type);
	
	public void notifyObservers(int type);

}
