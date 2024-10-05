package pavani;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class harshini {

	private JFrame frame;
	
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtrice;

	/**


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					harshini window = new harshini();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public harshini() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("super marketl");
		lblNewLabel.setBounds(183, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel);
	}

}
