package gui;

import java.awt.EventQueue;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class sandhani {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sandhani window = new sandhani();
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
	public sandhani() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC COLLEGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(236, 11, 360, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(64, 110, 64, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GENDER");
		lblNewLabel_1_1.setBounds(64, 155, 64, 17);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("BRANCH");
		lblNewLabel_1_2.setBounds(64, 210, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ROLL");
		lblNewLabel_1_3.setBounds(64, 285, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(159, 107, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 152, 96, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 207, 96, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 282, 96, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","S@ndhani@1274#");
					stmt=con.createStatement();
					String name= textField.getText();
					String gender= textField_1.getText();
					String branch= textField_2.getText();
					int age=Integer.parseInt(textField_4.getText());
					int roll= Integer.parseInt(textField_3.getText());
					
					
					
					String INSERT="INSERT INTO sa VALUES('"+name+"','"+gender+"','"+branch+"','"+age+"','"+roll+"');";
					stmt.executeUpdate(INSERT);
					System.out.println("thanks  for entering the data");
					btnNewButton.setEnabled(true);
				}
				catch(Exception e2)
				{
					System.out.println("enter the age lessthan 100");
				}

			}
		});
		btnNewButton.setBounds(61, 340, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRetrive = new JButton("display");
		btnRetrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stmt=null;
				ResultSet rs1=null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","S@ndhani@1274#");
					stmt=(Statement) con.createStatement();
					String name;
					name=String.valueOf(textField.getText());
					
					String sql="select gender,branch,age,roll from sandani where name='"+name+"'"; 
				 	rs1=stmt.executeQuery(sql);
					rs1.next();
					textField_1.setText(rs1.getString(1));
					textField_2.setText(rs1.getString(2));
					textField_3.setText(rs1.getString(3));
					
				}
				catch(Exception e2)
				{
					System.out.println("nope!!!");
				}

			}
		});
		btnRetrive.setBounds(166, 340, 89, 23);
		frame.getContentPane().add(btnRetrive);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("age");
		lblNewLabel_1_2_1.setBounds(64, 260, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 251, 96, 20);
		frame.getContentPane().add(textField_4);
	}
}
