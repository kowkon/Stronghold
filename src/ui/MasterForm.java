package ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.storage.Armory;
import buildings.storage.Granary;
import buildings.storage.Stockpile;
import castle.Castle;
import items.industrial.Iron;
import items.industrial.Wood;

public class MasterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Castle castle = new Castle();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterForm frame = new MasterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MasterForm() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(100, 100, 450, 300);
		setTitle("Stronghold");

		startBuildings();

		JButton btnStockpile = new JButton("Stockpile");
		btnStockpile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StockpileFrame sf = new StockpileFrame(castle);
				sf.setVisible(true);
			}
		});
		
		JButton btnGranary = new JButton("Granary");
		btnGranary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GranaryFrame gf = new GranaryFrame(castle);
				gf.setVisible(true);
			}
		});
		
		JButton btnArmory = new JButton("Armory");
		btnArmory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArmoryFrame af = new ArmoryFrame(castle);
				af.setVisible(true);
			}
		});
		
		JButton btnBuildings = new JButton("Buildings");
		btnBuildings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingsFrame bf = new BuildingsFrame(castle);
				bf.setVisible(true);
			}
		});
		
		contentPane.add(btnBuildings);
		contentPane.add(btnStockpile);
		contentPane.add(btnGranary);
		contentPane.add(btnArmory);

	}

	private void startBuildings() {
		Stockpile s = new Stockpile(castle);
		s.addItem(new Wood(30));
		s.addItem(new Iron(30));
		castle.addBuilding(s);
		castle.addBuilding(new Granary(castle));
		castle.addBuilding(new Armory(castle));
	}

}
