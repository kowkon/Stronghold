package buildings.storage;

import ui.textFields.DisplayObserver;

public interface IGranary {
	
	public static final int apple = 1;
	public static final int bread = 2;
	public static final int cheese = 3;
	public static final int meat = 4;
	
	public void register(DisplayObserver displayObserver, int type);
	
	public void unregister(DisplayObserver displayObserver, int type);
	
	public void notifyObservers(int type);

}
