package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import castle.Castle;

public class BuildingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public BuildingsFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(5, 0));
		setContentPane(contentPane);
		setTitle("Buildings");

		JButton btnIndustryBuildings = new JButton("Industry");
		btnIndustryBuildings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IndustryBuildingsFrame ibf = new IndustryBuildingsFrame(castle);
				ibf.setVisible(true);
			}
		});

		JButton btnFarmBuildings = new JButton("Farm");
		btnFarmBuildings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FarmBuildingsFrame fbf = new FarmBuildingsFrame(castle);
				fbf.setVisible(true);
			}
		});

		JButton btnFoodProcessing = new JButton("Food Processing");
		btnFoodProcessing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FoodProcessingBuildingsFrame fpbf = new FoodProcessingBuildingsFrame(castle);
				fpbf.setVisible(true);
			}
		});

		JButton btnWeapon = new JButton("Weapon");
		btnWeapon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WeaponBuildingsFrame wbf = new WeaponBuildingsFrame(castle);
				wbf.setVisible(true);
			}
		});

		contentPane.add(btnIndustryBuildings);
		contentPane.add(btnFarmBuildings);
		contentPane.add(btnFoodProcessing);
		contentPane.add(btnWeapon);

	}

}
