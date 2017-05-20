package ui.textFields;

import javax.swing.JTextField;

import buildings.Building;
import buildings.storage.Armory;
import castle.Castle;

public class ArmoryObserver extends JTextField implements DisplayObserver {

	private static final long serialVersionUID = 1L;

	public ArmoryObserver(int type, Castle castle) {
		setEditable(false);
		for (Building b : castle.getBuildings()) {
			if (b instanceof Armory) {
				((Armory) b).register(this, type);
				break;
			}
		}
	}
	
	@Override
	public void update(int amount) {
		setText(amount + "");
	}

}
