package dbconnectivity;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jdbc {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbc window = new jdbc();
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
	public jdbc() {
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
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
		
		});
		textField.setBounds(220, 49, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("rice");
		lblNewLabel.setBounds(131, 52, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 103, 96, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblPassowrd = new JLabel("oil");
		lblPassowrd.setBounds(131, 106, 49, 14);
		frame.getContentPane().add(lblPassowrd);
		
		textField_2 = new JTextField();
	

		textField_2.setBounds(220, 219, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_1 = new JLabel("total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(92, 211, 83, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("wheat");
		lblNewLabel_2.setBounds(131, 155, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 152, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					double x,y,z,tot;
					x=Double.parseDouble(textField.getText());
					y=Double.parseDouble(textField_1.getText());
					z=Double.parseDouble(textField_3.getText());
					tot=x+y+z;
					textField_2.setText(Double.toString(tot));
					
				}
				
			});
			
		btnNewButton.setBounds(109, 180, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		}
	}




