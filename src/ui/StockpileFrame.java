package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import buildings.storage.IStockpile;
import castle.Castle;
import ui.textFields.StockpileObserver;

public class StockpileFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StockpileFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Stockpile");

		//------------name labels---------
		JLabel lblWood = new JLabel("Wood");
		lblWood.setBounds(55, 5, 50, 30);

		JLabel lblStone = new JLabel("Stone");
		lblStone.setBounds(205, 5, 50, 30);

		JLabel lblIron = new JLabel("Iron");
		lblIron.setBounds(355, 5, 50, 30);

		JLabel lblWheat = new JLabel("Wheat");
		lblWheat.setBounds(55, 200, 50, 30);

		JLabel lblFlour = new JLabel("Flour");
		lblFlour.setBounds(205, 200, 50, 30);

		//----------images-------------
		JLabel lblWoodImage = new JLabel();
		lblWoodImage.setBounds(5, 25, 128, 128);
		lblWoodImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/wood.png")));

		JLabel lblStoneImage = new JLabel();
		lblStoneImage.setBounds(163, 25, 128, 128);
		lblStoneImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/stone.png")));

		JLabel lblIronImage = new JLabel();
		lblIronImage.setBounds(321, 25, 128, 128);
		lblIronImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/iron.png")));

		JLabel lblFlourImage = new JLabel();
		lblFlourImage.setBounds(5, 230, 128, 128);
		lblFlourImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/flour.png")));

		JLabel lblWheatImage = new JLabel();
		lblWheatImage.setBounds(163, 230, 128, 128);
		lblWheatImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/wheat.png")));
		
		
		//------text fields--------------
		StockpileObserver woodField = new StockpileObserver(IStockpile.wood, castle);
		woodField.setBounds(44, 160, 50, 30);

		StockpileObserver stoneField = new StockpileObserver(IStockpile.stone, castle);
		stoneField.setBounds(202, 160, 50, 30);

		StockpileObserver ironField = new StockpileObserver(IStockpile.iron, castle);
		ironField.setBounds(360, 160, 50, 30);

		StockpileObserver flourField = new StockpileObserver(IStockpile.flour, castle);
		flourField.setBounds(44, 370, 50, 30);

		StockpileObserver wheatField = new StockpileObserver(IStockpile.wheat, castle);
		wheatField.setBounds(202, 370, 50, 30);

		//-------------adding to panel-------------
		contentPane.add(lblWood);
		contentPane.add(lblWoodImage);
		contentPane.add(woodField);

		contentPane.add(lblStone);
		contentPane.add(lblStoneImage);
		contentPane.add(stoneField);

		contentPane.add(lblIron);
		contentPane.add(lblIronImage);
		contentPane.add(ironField);

		contentPane.add(lblWheat);
		contentPane.add(lblWheatImage);
		contentPane.add(wheatField);

		contentPane.add(lblFlour);
		contentPane.add(lblFlourImage);
		contentPane.add(flourField);

	}

}
