package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;

import javax.swing.JButton;

public class DeleteEmployee {

	private JFrame frame;
	private JTextField textField;
	Employee emp = new Employee();
	private EmployeeController employeecontroller;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new DeleteEmployee();
				
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
	private void DeleteEmployee() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Employee Frame");
		lblDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeleteEmployee.setBounds(121, 41, 204, 20);
		frame.getContentPane().add(lblDeleteEmployee);
		
		JLabel lblEnterEmpId = new JLabel("Enter EmpId");
		lblEnterEmpId.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEnterEmpId.setBounds(66, 115, 84, 14);
		frame.getContentPane().add(lblEnterEmpId);
		
		textField = new JTextField();
		textField.setBounds(169, 110, 144, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		
			employeecontroller = new EmployeeController();
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EID;
				EID = Integer.parseInt(textField.getText());
				employeecontroller.DeleteEmployee(EID);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(66, 185, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(199, 187, 89, 23);
		frame.getContentPane().add(btnBack);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeleteEmployee() throws ClassNotFoundException, SQLException {
		DeleteEmployee();
	}
}
