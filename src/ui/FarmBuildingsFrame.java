package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.farm.AppleOrchard;
import buildings.farm.DairyFarm;
import buildings.farm.HuntersPost;
import buildings.farm.WheatFarm;
import buildings.storage.IStockpile;
import castle.Castle;
import ui.textFields.StockpileObserver;

public class FarmBuildingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FarmBuildingsFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 320, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Farm Buildings");

		JLabel lblAppleOrchardImage = new JLabel();
		lblAppleOrchardImage.setBounds(5, 5, 128, 128);
		lblAppleOrchardImage.setIcon(
				new ImageIcon(FarmBuildingsFrame.class.getResource("/resources/images/x128/buildings/appleOrchard.png")));
		JLabel lblAppleOrchardWood = new JLabel("10");
		lblAppleOrchardWood.setBounds(60, 150, 40, 20);

		JLabel lblHuntersPostImage = new JLabel();
		lblHuntersPostImage.setBounds(163, 5, 128, 128);
		lblHuntersPostImage
				.setIcon(new ImageIcon(FarmBuildingsFrame.class.getResource("/resources/images/x128/buildings/huntersPost.png")));
		JLabel lblHuntersPostWood = new JLabel("10");
		lblHuntersPostWood.setBounds(230, 150, 40, 20);

		JLabel lblWheatFarmImage = new JLabel();
		lblWheatFarmImage.setBounds(5, 215, 128, 128);
		lblWheatFarmImage
				.setIcon(new ImageIcon(FarmBuildingsFrame.class.getResource("/resources/images/x128/buildings/wheatFarm.png")));
		JLabel lblWheatFarmWood = new JLabel("15");
		lblWheatFarmWood.setBounds(60, 350, 40, 20);

		JLabel lblDairyFarmImage = new JLabel();
		lblDairyFarmImage.setBounds(163, 215, 128, 128);
		lblDairyFarmImage
				.setIcon(new ImageIcon(FarmBuildingsFrame.class.getResource("/resources/images/x128/buildings/dairyFarm.png")));
		JLabel lblDairyFarmWood = new JLabel("10");
		lblDairyFarmWood.setBounds(230, 350, 40, 20);

		JButton btnAppleOrchard = new JButton("Apple Orchard");
		btnAppleOrchard.setBounds(20, 180, 100, 20);
		btnAppleOrchard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new AppleOrchard(castle));
			}
		});

		JButton btnHuntersPost = new JButton("Hunter's Post");
		btnHuntersPost.setBounds(180, 180, 100, 20);
		btnHuntersPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new HuntersPost(castle));
			}
		});

		JButton btnWheatFarm = new JButton("Wheat Farm");
		btnWheatFarm.setBounds(20, 375, 100, 20);
		btnWheatFarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new WheatFarm(castle));
			}
		});

		JButton btnDairyFarm = new JButton("Dairy Farm");
		btnDairyFarm.setBounds(180, 375, 100, 20);
		btnDairyFarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new DairyFarm(castle));
			}
		});
		
		StockpileObserver stockpileWood = new StockpileObserver(IStockpile.wood, castle);
		stockpileWood.setBounds(50, 410, 50, 20);

		contentPane.add(btnAppleOrchard);
		contentPane.add(lblAppleOrchardImage);
		contentPane.add(lblAppleOrchardWood);

		contentPane.add(btnHuntersPost);
		contentPane.add(lblHuntersPostImage);
		contentPane.add(lblHuntersPostWood);

		contentPane.add(btnWheatFarm);
		contentPane.add(lblWheatFarmImage);
		contentPane.add(lblWheatFarmWood);

		contentPane.add(btnDairyFarm);
		contentPane.add(lblDairyFarmImage);
		contentPane.add(lblDairyFarmWood);
		
		contentPane.add(stockpileWood);
	}

}
