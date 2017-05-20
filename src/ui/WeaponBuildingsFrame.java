package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.weapon.ArmourersWorkshop;
import buildings.weapon.BlacksmithsWorkshop;
import buildings.weapon.FletchersWorkshop;
import buildings.weapon.PoleturnersWorkshop;
import buildings.weapon.TannersWorkshop;
import castle.Castle;

public class WeaponBuildingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public WeaponBuildingsFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Weapon Buildings");
		setBounds(100, 100, 480, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblFletcherWorkshopImage = new JLabel();
		lblFletcherWorkshopImage.setBounds(5, 5, 128, 128);
		lblFletcherWorkshopImage.setIcon(new ImageIcon(
				WeaponBuildingsFrame.class.getResource("/resources/images/x128/buildings/fletchersWorkshop.png")));

		JLabel lblPolenturnersWorkshop = new JLabel();
		lblPolenturnersWorkshop.setBounds(163, 5, 128, 128);
		lblPolenturnersWorkshop.setIcon(new ImageIcon(
				WeaponBuildingsFrame.class.getResource("/resources/images/x128/buildings/polenturnersWorkshop.png")));

		JLabel lblTannersWorkshop = new JLabel();
		lblTannersWorkshop.setBounds(321, 5, 128, 128);
		lblTannersWorkshop.setIcon(new ImageIcon(
				WeaponBuildingsFrame.class.getResource("/resources/images/x128/buildings/tannersWorkshop.png")));

		JLabel lblBlacksmithsWorkshop = new JLabel();
		lblBlacksmithsWorkshop.setBounds(5, 215, 128, 128);
		lblBlacksmithsWorkshop.setIcon(new ImageIcon(
				WeaponBuildingsFrame.class.getResource("/resources/images/x128/buildings/blacksmithsWorkshop.png")));

		JLabel lblArmourersWorkshop = new JLabel();
		lblArmourersWorkshop.setBounds(163, 215, 128, 128);
		lblArmourersWorkshop.setIcon(new ImageIcon(
				WeaponBuildingsFrame.class.getResource("/resources/images/x128/buildings/armourersWorkshop.png")));

		JButton btnFletchers = new JButton("Fletcher's Workshop");
		btnFletchers.setBounds(20, 180, 100, 20);
		btnFletchers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new FletchersWorkshop(castle));
			}
		});

		JButton btnPolenturners = new JButton("Polenturner's Workshop");
		btnPolenturners.setBounds(180, 180, 100, 20);
		btnPolenturners.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new PoleturnersWorkshop(castle));
			}
		});

		JButton btnTanners = new JButton("Tanner's Workshop");
		btnTanners.setBounds(340, 180, 100, 20);
		btnTanners.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new TannersWorkshop(castle));
			}
		});

		JButton btnArmourer = new JButton("Amourer's Workshop");
		btnArmourer.setBounds(180, 375, 100, 20);
		btnArmourer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new ArmourersWorkshop(castle));
			}
		});

		JButton btnBlacksmiths = new JButton("Blacksmith's Workshop");
		btnBlacksmiths.setBounds(20, 375, 100, 20);
		btnBlacksmiths.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castle.addBuilding(new BlacksmithsWorkshop(castle));
			}
		});

		contentPane.add(lblFletcherWorkshopImage);
		contentPane.add(btnFletchers);

		contentPane.add(btnPolenturners);
		contentPane.add(lblPolenturnersWorkshop);

		contentPane.add(btnTanners);
		contentPane.add(lblTannersWorkshop);

		contentPane.add(btnBlacksmiths);
		contentPane.add(lblBlacksmithsWorkshop);

		contentPane.add(btnArmourer);
		contentPane.add(lblArmourersWorkshop);

	}

}
