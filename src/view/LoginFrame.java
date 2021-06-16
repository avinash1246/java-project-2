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

import daoimpl.EmployeeDao;
import model.Employee;
import view.EmployeeHomeScreen;
import view.HRAFrame;
import view.PMEHomeScreen;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	EmployeeController empController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginFrame();
					
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
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void FrameLogin() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 441, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblUsername.setBounds(48, 57, 85, 30);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPassword.setBounds(48, 123, 85, 30);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(172, 60, 167, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 126, 167, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		empController = new EmployeeController();
		//Event handling for Login button
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				Employee emp=new Employee();

				userId=textField.getText();
				
				password=new String(passwordField.getPassword());
				emp=empController.checkLogin(userId, password);
				if(emp.getUserId()==null || emp.getPassword()==null) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"You are not authorized user! Retry or Register!");
				}
				else {
					if(emp.getActive().equals("yes")) {
						if(emp.getRole().equals("HRA")) {
							new HRAFrame(emp);
							frame.dispose();
						}
						else if(emp.getRole().equals("PME")) {
							new PMEHomeScreen();
							frame.dispose();
						}
						else {
							try {
								new EmployeeHomeScreen(emp);
								frame.dispose();
							} catch (ClassNotFoundException | SQLException e) {
							
								e.printStackTrace();
							}
						}
					}
					else {
						JFrame f=new JFrame();
						JOptionPane.showMessageDialog(f,"User not activated !...");
					}
				}	
			}
		});
		btnLogin.setBounds(113, 175, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister= new JButton("Register");
		 btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new RegistrationFrame();
					frame.dispose();
				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
		});
		 btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnRegister.setBounds(239, 173, 111, 23);
		frame.getContentPane().add( btnRegister);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public LoginFrame() throws ClassNotFoundException, SQLException {
		FrameLogin();
	}
}
