import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class STUDENTMANAGEMENT {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUDENTMANAGEMENT window = new STUDENTMANAGEMENT();
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
	public STUDENTMANAGEMENT() {
		initialize();
		Connect();
		table_load();
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public void Connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sandhani","root","S@ndhani@1274#");
		}
		catch (ClassNotFoundException ex) {
			
		}
		catch(SQLException e1) {
			e1.printStackTrace();
			
		}
	}
	public void table_load()
	{
		try {
			pst=con.preparedStatement(" select * from studentdetails");
			rs=pst.executeQuery();
			scrollPane.setModel(DbUtils.resultSettoTableModel(rs));
			
			
			
			
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 913, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT DETAILS FOR ABC COLLEGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		lblNewLabel.setBounds(115, 22, 723, 97);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(288, 164, -72, 22);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 89, 397, 268);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DETAILS ENTRY");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBounds(10, 11, 230, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ROLL NUMBER");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(10, 113, 230, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME OF THE STUDENT");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 65, 230, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("AGE");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_3.setBounds(10, 153, 230, 28);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("PHONE NUMBER");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_4.setBounds(10, 192, 230, 28);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("BRANCH");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_5.setBounds(10, 229, 230, 28);
		panel.add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setBounds(198, 70, 172, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(198, 119, 172, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 152, 172, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 192, 172, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(198, 231, 172, 20);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name,roll,age,phonenumber,branch;
				name=TextFeild.getText();
				roll=TextFeild_1.getText();
				age=TextFeild_2.getText();
				phonenumber=TextFeild_3.getText();
				branch=TextFeild_4.getText();
				
				pst=con.preparedstatement("insert into studentdetails(name,roll,age,phonenumber,branch)values(?,?,?)");
				pst.setString(1, name);
				pst.setString(2,roll);
				pst.setString(3, age);
				pst.setString(4, age);
				pst.setString(5, branch);
				pst.executeUpdate();
				Joptionpane.showMessageDialog(null,"recordadded!!!");
				TextFeild.setText("");
				TextFeild_1.setText("");
				TextFeild_2.setText("");
				TextFeild_3.setText("");
				TextFeild_4.setText("");
				
				TextFeild.requestFocus();
				
				
				
			}
		
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(58, 358, 121, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(189, 358, 121, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnClear.setBounds(336, 358, 121, 27);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(481, 86, 350, 300);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setToolTipText("SEARCH");
		panel_1.setBounds(60, 396, 378, 71);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ROLL NUMBER");
		lblNewLabel_1_3_1.setBounds(30, 22, 156, 22);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_1.add(lblNewLabel_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(196, 25, 172, 20);
		panel_1.add(textField_5);
		
		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(511, 397, 121, 27);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("DELETE");
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(669, 397, 121, 27);
		frame.getContentPane().add(btnNewButton_1_2);
	}
}
