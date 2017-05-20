package ui.textFields;

import javax.swing.JTextField;

import buildings.Building;
import buildings.storage.Stockpile;
import castle.Castle;

public class StockpileObserver extends JTextField implements DisplayObserver {

	private static final long serialVersionUID = 1L;

	public StockpileObserver(int type, Castle castle) {
		setEditable(false);
		for (Building b : castle.getBuildings()) {
			if (b instanceof Stockpile) {
				((Stockpile) b).register(this, type);
				break;
			}
		}
	}

	@Override
	public void update(int amount) {
		setText(amount + "");
	}

}
