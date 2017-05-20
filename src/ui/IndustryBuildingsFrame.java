package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.industry.IronMine;
import buildings.industry.OxTether;
import buildings.industry.Quarry;
import buildings.industry.Woodcutter;
import buildings.storage.IStockpile;
import castle.Castle;
import items.industrial.Stone;
import ui.textFields.StockpileObserver;

public class IndustryBuildingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IndustryBuildingsFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 320, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Industry Buildings");

		JLabel woodcutterImage = new JLabel();
		woodcutterImage.setBounds(5, 5, 128, 128);
		woodcutterImage.setIcon(new ImageIcon(
				IndustryBuildingsFrame.class.getResource("/resources/images/x128/buildings/woodcutter.png")));
		JLabel lblWoodcutterWoodImage = new JLabel();
		lblWoodcutterWoodImage.setBounds(30, 150, 20, 20);
		lblWoodcutterWoodImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x20/items/wood.png")));
		JLabel woodcutterWoodCost = new JLabel("5");
		woodcutterWoodCost.setBounds(60, 150, 40, 20);

		JLabel quarryImage = new JLabel();
		quarryImage.setBounds(163, 5, 128, 128);
		quarryImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x128/buildings/quarry.png")));
		JLabel lblQuarryWoodImage = new JLabel();
		lblQuarryWoodImage.setBounds(200, 150, 20, 20);
		lblQuarryWoodImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x20/items/wood.png")));
		JLabel quarryWoodCost = new JLabel("20");
		quarryWoodCost.setBounds(230, 150, 40, 20);

		JLabel oxTetherImage = new JLabel();
		oxTetherImage.setBounds(5, 215, 128, 128);
		oxTetherImage.setIcon(new ImageIcon(
				IndustryBuildingsFrame.class.getResource("/resources/images/x128/buildings/oxTether.png")));
		JLabel oxTetherWoodImage = new JLabel();
		oxTetherWoodImage.setBounds(30, 350, 20, 20);
		oxTetherWoodImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x20/items/wood.png")));
		JLabel oxTetherWoodCost = new JLabel("10");
		oxTetherWoodCost.setBounds(60, 350, 40, 20);

		JLabel ironmineImage = new JLabel();
		ironmineImage.setBounds(163, 215, 128, 128);
		ironmineImage.setIcon(new ImageIcon(
				IndustryBuildingsFrame.class.getResource("/resources/images/x128/buildings/ironmine.png")));
		JLabel lblIronmineWoodImage = new JLabel();
		lblIronmineWoodImage.setBounds(200, 350, 20, 20);
		lblIronmineWoodImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x20/items/wood.png")));
		JLabel ironmineWoodCost = new JLabel("20");
		ironmineWoodCost.setBounds(230, 350, 40, 20);

		JButton btnWoodcutter = new JButton("Woodcutter");
		btnWoodcutter.setBounds(20, 180, 100, 20);
		btnWoodcutter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new Woodcutter(castle));
			}
		});

		JButton btnQuarry = new JButton("Quarry");
		btnQuarry.setBounds(180, 180, 100, 20);
		btnWoodcutter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new Quarry(castle));
			}
		});

		JButton btnOxTether = new JButton("Ox Tether");
		btnOxTether.setBounds(20, 375, 100, 20);
		btnOxTether.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new OxTether(castle, new Stone()));
			}
		});

		JButton btnIronmine = new JButton("Iron mine");
		btnIronmine.setBounds(180, 375, 100, 20);
		btnIronmine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new IronMine(castle));
			}
		});

		StockpileObserver stockpileWood = new StockpileObserver(IStockpile.wood, castle);
		stockpileWood.setBounds(60, 410, 50, 20);

		JLabel stockpileWoodImage = new JLabel();
		stockpileWoodImage.setBounds(30, 410, 20, 20);
		stockpileWoodImage.setIcon(
				new ImageIcon(IndustryBuildingsFrame.class.getResource("/resources/images/x20/items/wood.png")));

		contentPane.add(woodcutterImage);
		contentPane.add(woodcutterWoodCost);
		contentPane.add(lblWoodcutterWoodImage);
		contentPane.add(btnWoodcutter);

		contentPane.add(quarryImage);
		contentPane.add(quarryWoodCost);
		contentPane.add(lblQuarryWoodImage);
		contentPane.add(btnQuarry);

		contentPane.add(ironmineImage);
		contentPane.add(ironmineWoodCost);
		contentPane.add(lblIronmineWoodImage);
		contentPane.add(btnIronmine);

		contentPane.add(oxTetherImage);
		contentPane.add(oxTetherWoodCost);
		contentPane.add(oxTetherWoodImage);
		contentPane.add(btnOxTether);

		contentPane.add(stockpileWood);
		contentPane.add(stockpileWoodImage);
	}

}
