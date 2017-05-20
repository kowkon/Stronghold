package buildings.storage;

import ui.textFields.DisplayObserver;

public interface IArmory {

	public static final int bow = 1;
	public static final int crossbow = 2;
	public static final int leatherArmor = 3;
	public static final int mace = 4;
	public static final int metalArmor = 5;
	public static final int pike = 6;
	public static final int spear = 7;
	public static final int sword = 8;

	public void register(DisplayObserver displayObserver, int type);

	public void unregister(DisplayObserver displayObserver, int type);

	public void notifyObservers(int type);

}
