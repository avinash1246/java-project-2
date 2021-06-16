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

import javax.swing.JButton;

public class DeactivateEmployeeFrame {

	private JFrame frame;
	private JTextField textField;
	private EmployeeController EmployeeController;
	Employee emp;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new DeactivateEmployeeFrame();
					
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
	public DeactivateEmployeeFrame(Employee emp) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 441, 157);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEmployeeID = new JLabel("Enter USER Name");
		lblEmployeeID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmployeeID.setBounds(25, 39, 119, 14);
		frame.getContentPane().add(lblEmployeeID);
		
		textField = new JTextField();
		textField.setBounds(165, 34, 158, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDeactivate = new JButton("Deactivate");
        EmployeeController  = new EmployeeController();
	    btnDeactivate.addActionListener(new ActionListener() {
	    @Override
			public void actionPerformed(ActionEvent e) {
				String UID;
				System.out.println(emp.getRole());
				UID = textField.getText();
				
				
			if(!emp.getRole().equals("HRA")){
				//s=Integer.parseInt(tEmployeeId.getText());
				EmployeeController.deactivateEmployee(UID);
				JOptionPane.showMessageDialog(frame, "Deactivated Successfully");
			}
			else {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Unable to Access");
			}
			}
			
		});
		btnDeactivate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeactivate.setBounds(165, 81, 119, 23);
		frame.getContentPane().add(btnDeactivate);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	/*public DeactivateEmployeeFrame(Employee emp) throws ClassNotFoundException, SQLException {
		this.emp=emp;
		DeactivateEmployee();
	}*/

}
