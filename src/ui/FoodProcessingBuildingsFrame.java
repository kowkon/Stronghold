package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.foodProcessing.Bakery;
import buildings.foodProcessing.Mill;
import buildings.storage.IStockpile;
import castle.Castle;
import ui.textFields.StockpileObserver;

public class FoodProcessingBuildingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FoodProcessingBuildingsFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Food Processing");

		JLabel lblMillImage = new JLabel();
		lblMillImage.setBounds(5, 5, 128, 128);
		lblMillImage.setIcon(new ImageIcon(
				FoodProcessingBuildingsFrame.class.getResource("/resources/images/x128/buildings/mill.png")));
		JLabel lblMillWood = new JLabel("20");
		lblMillWood.setBounds(60, 150, 40, 20);

		JLabel lblBakeryImage = new JLabel();
		lblBakeryImage.setBounds(163, 5, 128, 128);
		lblBakeryImage.setIcon(new ImageIcon(
				FoodProcessingBuildingsFrame.class.getResource("/resources/images/x128/buildings/bakery.png")));
		JLabel lblBakeryWood = new JLabel("10");
		lblBakeryWood.setBounds(230, 150, 40, 20);
		
		JLabel lblGranaryImage = new JLabel();
		lblGranaryImage.setBounds(5, 215, 128, 128);
		lblGranaryImage.setIcon(new ImageIcon(FoodProcessingBuildingsFrame.class.getResource("/resources/images/x128/buildings/granary.png")));
		JLabel lblGranaryWood = new JLabel("5");
		lblGranaryWood.setBounds(60, 350, 40, 20);

		JButton btnMill = new JButton("Mill");
		btnMill.setBounds(20, 180, 100, 20);
		btnMill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mill m = new Mill(castle);
				castle.addBuilding(m);
			}
		});

		JButton btnBakery = new JButton("Bakery");
		btnBakery.setBounds(180, 180, 100, 20);
		btnBakery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bakery b = new Bakery(castle);
				castle.addBuilding(b);
			}
		});
		
		JButton btnGranary = new JButton("Granary");
		btnGranary.setBounds(20, 375, 100, 20);
		btnGranary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		StockpileObserver stockpileWood = new StockpileObserver(IStockpile.wood, castle);
		stockpileWood.setBounds(50, 410, 50, 20);

		contentPane.add(lblMillImage);
		contentPane.add(btnMill);
		contentPane.add(lblMillWood);

		contentPane.add(lblBakeryImage);
		contentPane.add(btnBakery);
		contentPane.add(lblBakeryWood);
		
		contentPane.add(lblGranaryImage);
		contentPane.add(btnGranary);
		contentPane.add(lblGranaryWood);
		
		contentPane.add(stockpileWood);

	}

}
