package supermarket;

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
import java.awt.event.ActionEvent;

public class charan {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					charan window = new charan();
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
	public charan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 878, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("supermarket");
		lblNewLabel.setBounds(337, 37, 216, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("rice");
		lblNewLabel_1.setBounds(77, 147, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("sugar");
		lblNewLabel_1_2.setBounds(77, 227, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ps");
		lblNewLabel_1_3.setBounds(77, 281, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(176, 144, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 224, 96, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 278, 96, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("enter ");
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
					String rice= textField.getText();
					Double riceprice =Double.parseDouble(txtrice.getText());
					
		
					String sugar= textField_2.getText();
				
					Double sugarprice= Double.parseDouble(textField_3.getText());
					
					String INSERT="INSERT INTO raghu VALUES('"+sugar+"','"+sugarprice+"','"+rice+"','"+riceprice+"');";
					stmt.executeUpdate(INSERT);
					System.out.println("Record inserted successfully");
					btnNewButton.setEnabled(true);
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}});
		btnNewButton.setBounds(77, 403, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRetrive = new JButton("retrive");
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
					String rice;
					rice=String.valueOf(textField.getText());
					
					String sql="select sugar,sugarprice,riceprice from raghu where rice='"+rice+"'"; 
				 	rs1=stmt.executeQuery(sql);
					rs1.next();
					txtrice.setText(rs1.getString(1));
					textField_2.setText(rs1.getString(2));
					textField_3.setText(rs1.getString(3));
					
				}
				catch(Exception e2)
				{
					System.out.println("retrive cheydam kudradhu!!!");
				}

			}
		});
		btnRetrive.setBounds(210, 403, 89, 23);
		frame.getContentPane().add(btnRetrive);
		
		JLabel lblNewLabel_2 = new JLabel("riceprice");
		lblNewLabel_2.setBounds(77, 330, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtrice = new JTextField();
		txtrice.setBounds(176, 327, 96, 20);
		frame.getContentPane().add(txtrice);
		txtrice.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("total");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(619, 277, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
