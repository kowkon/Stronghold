package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.storage.IGranary;
import castle.Castle;
import ui.textFields.GranaryObserver;

public class GranaryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GranaryFrame(Castle castle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Granary");

		JLabel lblMeatImage = new JLabel();
		lblMeatImage.setBounds(5, 5, 128, 128);
		lblMeatImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/food/meat.png")));

		JLabel lblAppleImage = new JLabel();
		lblAppleImage.setBounds(163, 5, 128, 128);
		lblAppleImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/food/apple.png")));

		JLabel lblCheeseImage = new JLabel();
		lblCheeseImage.setBounds(163, 180, 128, 128);
		lblCheeseImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/food/cheese.png")));

		JLabel lblBreadImage = new JLabel();
		lblBreadImage.setBounds(5, 180, 128, 128);
		lblBreadImage.setIcon(new ImageIcon(StockpileFrame.class.getResource("/resources/images/x128/items/food/bread.png")));

		GranaryObserver meatField = new GranaryObserver(IGranary.meat, castle);
		meatField.setBounds(44, 140, 50, 30);

		GranaryObserver appleField = new GranaryObserver(IGranary.apple, castle);
		appleField.setBounds(202, 140, 50, 30);

		GranaryObserver cheeseField = new GranaryObserver(IGranary.cheese, castle);
		cheeseField.setBounds(202, 320, 50, 30);

		GranaryObserver breadField = new GranaryObserver(IGranary.bread, castle);
		breadField.setBounds(44, 320, 50, 30);

		contentPane.add(lblMeatImage);
		contentPane.add(meatField);

		contentPane.add(lblAppleImage);
		contentPane.add(appleField);

		contentPane.add(lblCheeseImage);
		contentPane.add(cheeseField);

		contentPane.add(lblBreadImage);
		contentPane.add(breadField);

	}

}
