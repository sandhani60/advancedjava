package main;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ento {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtroll;
	private JTextField txtbranch;
	private JTextField txtmedium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ento window = new ento();
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
	public ento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("student data");
		lblNewLabel.setBounds(331, 11, 129, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(86, 89, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("roll");
		lblNewLabel_1_1.setBounds(86, 154, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("branch");
		lblNewLabel_1_2.setBounds(86, 249, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("medium");
		lblNewLabel_1_3.setBounds(86, 313, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtname = new JTextField();
		txtname.setBounds(194, 86, 96, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtroll = new JTextField();
		txtroll.setColumns(10);
		txtroll.setBounds(194, 151, 96, 20);
		frame.getContentPane().add(txtroll);
		
		txtbranch = new JTextField();
		txtbranch.setColumns(10);
		txtbranch.setBounds(194, 246, 96, 20);
		frame.getContentPane().add(txtbranch);
		
		txtmedium = new JTextField();
		txtmedium.setColumns(10);
		txtmedium.setBounds(194, 310, 96, 20);
		frame.getContentPane().add(txtmedium);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con1;
				Statement stmt;
				/*PreparedStatement pstmt;*/
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sandhani","root","S@ndhani@1274#");
					stmt=con1.createStatement();
					String name=txtname.getText();
					String roll=txtroll.getText();
					String branch=txtbranch.getText();
					String medium=txtmedium.getText();
					
					/*pstmt=con1.prepareStatement("insert into students(name,roll,branch,medium)values(?,?,?,?)");*/
					
					/*stmt.executeUpdate(pstmt);*/
					String sql="insert into students values("+name+","+roll+","+branch+","+medium+")";
					stmt.executeUpdate(sql);
					System.out.println("inserted sucess");
					btnNewButton.setEnabled(true);
					
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(131, 380, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("retrive");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				ResultSet rs1=null;
				Statement stmt=null;
				try {
				Class.forName("com.sql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jbdc:mysql//localhost:3306","root","S@ndhani@1274#");
				stmt=con.createStatement();
				int roll;
				roll=Integer.parseInt(txtroll.getText());
				String sql="select name,branch,medium from students where roll="+roll;
				
				rs1=stmt.executeQuery(sql);
				rs1.next();
				txtname.setText(rs1.getString(1));
				txtroll.setText(rs1.getString(2));
				txtbranch.setText(rs1.getString(3));
				txtmedium.setText(rs1.getString(4));
				
				
				
				
			}catch(Exception e2) {
				System.out.println(e2);
			}
				
			}
		});
		btnNewButton_1.setBounds(290, 380, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
