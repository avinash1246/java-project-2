package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import model.Employee;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ViewProfile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Employee emp = new Employee();
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new ViewProfile();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     /**
	 * Initialize the contents of the frame.
	 */
	private void Profile() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmployeeID.setBounds(23, 36, 92, 14);
		frame.getContentPane().add(lblEmployeeID);
		
		textField = new JTextField(emp.getFirstName());
		textField.setColumns(10);
		textField.setBounds(161, 67, 182, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField(emp.getLastName());
		textField_1.setColumns(10);
		textField_1.setBounds(161, 106, 182, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField(emp.getRole());
		textField_2.setColumns(10);
		textField_2.setBounds(161, 186, 182, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Calibri", Font.BOLD, 14));
		lblRole.setBounds(23, 186, 80, 20);
		frame.getContentPane().add(lblRole);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 14));
		lblGender.setBounds(23, 150, 111, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLastName.setBounds(23, 108, 80, 20);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFirstName.setBounds(23, 72, 80, 14);
		frame.getContentPane().add(lblFirstName);
		
		textField_3 = new JTextField(Integer.toString(emp.getEmpId()));
		textField_3.setBounds(161, 31, 182, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EmployeeHomeScreen(emp);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(161, 294, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setFont(new Font("Calibri", Font.BOLD, 14));
		lblActive.setBounds(23, 231, 69, 14);
		frame.getContentPane().add(lblActive);
		
		textField_4 = new JTextField(emp.getActive());
		textField_4.setBounds(161, 226, 182, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(emp.getGender());
		textField_5.setBounds(161, 145, 182, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}
	/**
	 * Create the application.
	 */
	public ViewProfile(Employee emp) {
		this.emp = emp;
		Profile();
	}
	}

