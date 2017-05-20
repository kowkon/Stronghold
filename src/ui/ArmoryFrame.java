package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.storage.IArmory;
import castle.Castle;
import ui.textFields.ArmoryObserver;

public class ArmoryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ArmoryFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Armory");

		
		//---------name labels---------
		JLabel lblBow = new JLabel("Bow");
		lblBow.setBounds(55, 5, 50, 30);

		JLabel lblCrossbow = new JLabel("Crossbow");
		lblCrossbow.setBounds(195, 5, 70, 30);

		JLabel lblLeatherArmor = new JLabel("Leather Armor");
		lblLeatherArmor.setBounds(335, 5, 96, 30);

		JLabel lblMace = new JLabel("Mace");
		lblMace.setBounds(510, 5, 50, 30);

		JLabel lblMetalArmor = new JLabel("Metal Armor");
		lblMetalArmor.setBounds(35, 210, 80, 30);

		JLabel lblPike = new JLabel("Pike");
		lblPike.setBounds(210, 210, 50, 30);

		JLabel lblSpear = new JLabel("Spear");
		lblSpear.setBounds(360, 210, 50, 30);

		JLabel lblSword = new JLabel("Sword");
		lblSword.setBounds(510, 210, 50, 30);

		
		//---------text fields-------------
		ArmoryObserver bowField = new ArmoryObserver(IArmory.bow, castle);
		bowField.setBounds(44, 170, 50, 30);

		ArmoryObserver crossbowField = new ArmoryObserver(IArmory.crossbow, castle);
		crossbowField.setBounds(202, 170, 50, 30);

		ArmoryObserver leatherArmorField = new ArmoryObserver(IArmory.leatherArmor, castle);
		leatherArmorField.setBounds(360, 170, 50, 30);

		ArmoryObserver maceField = new ArmoryObserver(IArmory.mace, castle);
		maceField.setBounds(518, 170, 50, 30);

		ArmoryObserver metalArmorField = new ArmoryObserver(IArmory.metalArmor, castle);
		metalArmorField.setBounds(44, 380, 50,30);
		
		ArmoryObserver pikeField = new ArmoryObserver(IArmory.pike, castle);
		pikeField.setBounds(202, 380, 50, 30);
		
		ArmoryObserver spearField = new ArmoryObserver(IArmory.spear, castle);
		spearField.setBounds(360, 380, 50, 30);
		
		ArmoryObserver swordField = new ArmoryObserver(IArmory.sword, castle);
		swordField.setBounds(518, 380, 50, 30);

		//---------images----------
		JLabel lblBowImage = new JLabel();
		lblBowImage.setBounds(5, 35, 128, 128);
		lblBowImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/bow.png")));

		JLabel lblCrossbowImage = new JLabel();
		lblCrossbowImage.setBounds(163, 35, 128, 128);
		lblCrossbowImage
				.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/crossbow.png")));

		JLabel lblLeatherArmorImage = new JLabel();
		lblLeatherArmorImage.setBounds(321, 35, 128, 128);
		lblLeatherArmorImage
				.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/leatherArmor.png")));

		JLabel lblMaceImage = new JLabel();
		lblMaceImage.setBounds(479, 35, 128, 128);
		lblMaceImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/mace.png")));

		JLabel lblMetalArmorImage = new JLabel();
		lblMetalArmorImage.setBounds(5, 230, 128, 128);
		lblMetalArmorImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/metalArmor.png")));
		
		JLabel lblPikeImage = new JLabel();
		lblPikeImage.setBounds(163, 230, 128, 128);
		lblPikeImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/pike.png")));
		
		JLabel lblSpearImage = new JLabel();
		lblSpearImage.setBounds(321, 230, 128, 128);
		lblSpearImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/spear.png")));
		
		JLabel lblSwordImage = new JLabel();
		lblSwordImage.setBounds(479, 230, 128, 128);
		lblSwordImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/weapons/sword.png")));

		
		//-------adding components to the panel---------
		contentPane.add(lblBow);
		contentPane.add(lblBowImage);
		contentPane.add(bowField);

		contentPane.add(lblCrossbow);
		contentPane.add(lblCrossbowImage);
		contentPane.add(crossbowField);

		contentPane.add(lblLeatherArmor);
		contentPane.add(lblLeatherArmorImage);
		contentPane.add(leatherArmorField);

		contentPane.add(lblMace);
		contentPane.add(lblMaceImage);
		contentPane.add(maceField);

		contentPane.add(lblMetalArmor);
		contentPane.add(lblMetalArmorImage);
		contentPane.add(metalArmorField);

		contentPane.add(lblPike);
		contentPane.add(lblPikeImage);
		contentPane.add(pikeField);

		contentPane.add(lblSpear);
		contentPane.add(lblSpearImage);
		contentPane.add(spearField);

		contentPane.add(lblSword);
		contentPane.add(lblSwordImage);
		contentPane.add(swordField);

	}

}
