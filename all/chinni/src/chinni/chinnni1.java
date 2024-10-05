package chinni;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class chinnni1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chinnni1 window = new chinnni1();
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
	public chinnni1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 0, 128));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 889, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE DETAILS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(294, 11, 190, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmpname = new JLabel("empname");
		lblEmpname.setBackground(new Color(255, 0, 128));
		lblEmpname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmpname.setBounds(122, 94, 89, 23);
		frame.getContentPane().add(lblEmpname);
		
		JLabel lblEmpnum = new JLabel("empnum");
		lblEmpnum.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmpnum.setBounds(129, 172, 107, 14);
		frame.getContentPane().add(lblEmpnum);
		
		JLabel lblEmpsal = new JLabel("empsal");
		lblEmpsal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmpsal.setBounds(129, 249, 77, 17);
		frame.getContentPane().add(lblEmpsal);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
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
					String empname= textField.getText();
					
					int empnum=Integer.parseInt(textField_1.getText());
					int empsal= Integer.parseInt(textField_2.getText());
					
					
					
					String INSERT="INSERT INTO emp8 VALUES('"+empname+"','"+empnum+"','"+empsal+"');";
					stmt.executeUpdate(INSERT);
					System.out.println("thanks for entering data");
					btnNewButton.setEnabled(true);
				}
				catch(Exception e2)
				{
					System.out.println("sorry !! we cannot enter the data to the database");
				}

			}
		});
		btnNewButton.setBounds(147, 330, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRetrive = new JButton("retrive");
		btnRetrive.setFont(new Font("Times New Roman", Font.BOLD, 17));
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
					String empname;
					empname=String.valueOf(textField.getText());
					
					String sql="select empnum,empsal from emp where empname='"+empname+"'"; 
				 	rs1=stmt.executeQuery(sql);
					rs1.next();
					textField_1.setText(rs1.getString(1));
					textField_2.setText(rs1.getString(2));
					
					
				}
				catch(Exception e2)
				{
					System.out.println("nope!!!");
				}

			}
		});
		btnRetrive.setBounds(365, 330, 89, 23);
		frame.getContentPane().add(btnRetrive);
		
		textField = new JTextField();
		textField.setBounds(263, 95, 107, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 171, 107, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 249, 107, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(506, 332, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
