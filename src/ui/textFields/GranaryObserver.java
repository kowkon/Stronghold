package ui.textFields;

import javax.swing.JTextField;

import buildings.Building;
import buildings.storage.Granary;
import castle.Castle;

public class GranaryObserver extends JTextField implements DisplayObserver {

	private static final long serialVersionUID = 1L;

	public GranaryObserver(int type, Castle castle) {
		setEditable(false);
		for (Building b : castle.getBuildings()) {
			if (b instanceof Granary) {
				((Granary) b).register(this, type);
				break;
			}
		}
	}

	@Override
	public void update(int amount) {
		setText(amount + "");
	}

}
