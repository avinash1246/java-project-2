package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.EmployeeController;


import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistrationFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	EmployeeController employeecontroller=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new RegistrationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void registration() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblRegistrationFrame = new JLabel("Registration Form");
		lblRegistrationFrame.setFont(new Font("Calibri", Font.BOLD, 18));
		lblRegistrationFrame.setBounds(142, 30, 147, 20);
		frame.getContentPane().add(lblRegistrationFrame);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFirstName.setBounds(25, 74, 80, 14);
		frame.getContentPane().add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(163, 69, 182, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLastName.setBounds(25, 110, 80, 20);
		frame.getContentPane().add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 108, 182, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCreatePassword.setBounds(25, 197, 120, 14);
		frame.getContentPane().add(lblCreatePassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 192, 182, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblConfirmPassword.setBounds(25, 237, 108, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(163, 232, 182, 20);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Calibri", Font.BOLD, 14));
		lblRole.setBounds(25, 315, 80, 20);
		frame.getContentPane().add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Developer", "System Engineer"}));
		comboBox.setBounds(163, 313, 182, 20);
		frame.getContentPane().add(comboBox);
	//	comboBox.setColumns(10);
		
		JButton btnSUBMIT = new JButton("SUBMIT");
		employeecontroller=new EmployeeController();
		btnSUBMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UFN, ULN, UID, UP, UCP, UG, UR;
				UFN = textField.getText();
				ULN =textField_1.getText();
				UID = textField_4.getText();
				UP = new String(passwordField.getPassword());
				UG = textField_3.getText();
				UR = comboBox.getSelectedItem().toString();
				UCP = new String(passwordField_1.getPassword());
				
				if(UP.equals(UCP)) {
					employeecontroller.addEmployee(UFN,ULN,UID,UP,UG,UR);		//Values Added to Controller
					JOptionPane.showMessageDialog(frame,"Registered Succesfully");
					frame.dispose();
					try {
						new LoginFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
					else {
					JOptionPane.showMessageDialog(frame, "Check your Password and Retry ..!");
				}
			}
		});
				
		btnSUBMIT.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSUBMIT.setBounds(67, 355, 92, 29);
		frame.getContentPane().add(btnSUBMIT);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 14));
		lblGender.setBounds(24, 273, 46, 14);
		frame.getContentPane().add(lblGender);
		
		textField_3 = new JTextField();
		textField_3.setBounds(163, 268, 182, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUserID = new JLabel("UserID");
		lblUserID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUserID.setBounds(25, 156, 46, 14);
		frame.getContentPane().add(lblUserID);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 151, 181, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.setBounds(212, 353, 97, 28);
		frame.getContentPane().add(btnNewButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public RegistrationFrame() throws ClassNotFoundException, SQLException {
		registration();
	}
}
