package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buildings.storage.Stockpile;
import castle.Castle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasterForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Castle castle;
	private JTextField textField;
	private String s;

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
		castle = new Castle();
		s = "berat";
		startBuildings();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setText(s);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "asd";
				textField.repaint();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		textField.repaint();
	}

	private void startBuildings() {
		Stockpile stockpile = new Stockpile(castle);
	}

}
