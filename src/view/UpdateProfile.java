package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UpdateProfile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	Employee emp = new Employee();
	private EmployeeController employeecontroller;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new UpdateProfile();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void UpdateProfile() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 461, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblChangeFirstname = new JLabel("Change Firstname");
		lblChangeFirstname.setFont(new Font("Calibri", Font.BOLD, 14));
		lblChangeFirstname.setBounds(41, 64, 110, 14);
		frame.getContentPane().add(lblChangeFirstname);
		
		textField = new JTextField();
		textField.setBounds(176, 59, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblChangeLastname = new JLabel("Change Lastname");
		lblChangeLastname.setFont(new Font("Calibri", Font.BOLD, 14));
		lblChangeLastname.setBounds(41, 113, 110, 14);
		frame.getContentPane().add(lblChangeLastname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 108, 138, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblChangePassword.setBounds(41, 156, 110, 14);
		frame.getContentPane().add(lblChangePassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 151, 138, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblConfirmPassword.setBounds(41, 199, 110, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(176, 194, 138, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnSubmit = new JButton("Submit");
		employeecontroller = new EmployeeController();
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String UFN, ULN, UP, UCP, UID;
				UID = emp.getUserId();
				UFN = textField.getText();
				ULN = textField_1.getText();
				UP = new String(passwordField.getPassword());
				UCP = new String(passwordField_1.getPassword());
			if(UP.equals(UCP)) {
			    employeecontroller.updateEmployee(UFN, ULN, UP,UID);
				JOptionPane.showMessageDialog(frame, "Registered Successfully");
				frame.dispose();
				try {
					new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
			    	JOptionPane.showMessageDialog(frame,"Check your Password and Retry...!");
			    }
			}
		});
			    	
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBounds(41, 251, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EmployeeHomeScreen(emp);
				} catch (ClassNotFoundException | SQLException e1) {
			       e1.printStackTrace();
		}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(176, 253, 89, 23);
		frame.getContentPane().add(btnBack);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public UpdateProfile(Employee emp) throws ClassNotFoundException, SQLException {
		this.emp = emp;
		UpdateProfile();
	}
}
