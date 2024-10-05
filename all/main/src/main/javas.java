package main;

import java.awt.EventQueue;

import java.sql.*;






import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class javas {

	private JFrame frame;
	private JTable table;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtroll;
	private JTextField txtbranch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javas window = new javas();
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
	public javas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("student data");
		lblNewLabel.setBounds(298, 26, 149, 39);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		table.setBounds(456, 96, 384, 314);
		frame.getContentPane().add(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "entry details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(50, 85, 341, 279);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentName = new JLabel("student name");
		lblStudentName.setBounds(22, 44, 63, 14);
		panel.add(lblStudentName);
		
		JLabel lblNewLabel_1_1 = new JLabel("age");
		lblNewLabel_1_1.setBounds(22, 104, 63, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("roll");
		lblNewLabel_1_2.setBounds(22, 146, 63, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("branch");
		lblNewLabel_1_3.setBounds(22, 192, 63, 14);
		panel.add(lblNewLabel_1_3);
		
		txtname = new JTextField();
		txtname.setBounds(128, 41, 96, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(128, 101, 96, 20);
		panel.add(txtage);
		
		txtroll = new JTextField();
		txtroll.setColumns(10);
		txtroll.setBounds(128, 143, 96, 20);
		panel.add(txtroll);
		
		txtbranch = new JTextField();
		txtbranch.setColumns(10);
		txtbranch.setBounds(128, 189, 96, 20);
		panel.add(txtbranch);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =txtname.getText();
				String age =txtage.getText();
				String roll =txtroll.getText();
				String branch =txtbranch.getText();
				
				Connection con1;
				PreparedStatement insert;
				Statement stmt;
				ResultSet rs1;
				try {
				Class.forName("Driver.class");
				con1=DriverManager.getConnection("mysql:jdbc//localhost:3306/sandhani","root","S@ndhani@1274#");
				stmt=con1.createStatement();
				insert=con1.prepareStatement("insert into stud(name,age,roll,branch)values(?,?,?,?)");
				String sql="select name,rol,age,branch"+roll;
				ResultSet rs=stmt.executeQuery(sql);
				rs.next();
				txtname.setText(rs.getString(1));
				txtroll.setText(rs.getString(2));
				txtage.setText(rs.getString(3));
				txtbranch.setText(rs,getString(4));
				
				
				insert.setString(1,name);
				insert.setString(2,roll);
				insert.setString(3, age);
				insert.setString(4, branch);
				insert.executeUpdate();

				
				
				
				
				
			}
				catch(ClassNotFoundException ex) {
				}
				catch(SQLException e1) {
					
				}
			}});
		btnNewButton.setBounds(21, 233, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.setBounds(135, 233, 89, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setBounds(242, 233, 89, 23);
		panel.add(btnDelete);
	}
}
