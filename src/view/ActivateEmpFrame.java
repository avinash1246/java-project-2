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
import javax.swing.JButton;
import javax.swing.UIManager;

import controller.EmployeeController;


public class ActivateEmpFrame {

	private JFrame frame;
	private JTextField textField;
	private EmployeeController EmployeeController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ActivateEmpFrame();
					
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
	private void EmployeeActivation() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 201);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEmployeeID = new JLabel("Enter USER NAME");
		lblEmployeeID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmployeeID.setBounds(29, 62, 145, 14);
		frame.getContentPane().add(lblEmployeeID);
		
		textField = new JTextField();
		textField.setBounds(204, 57, 171, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnActivateButton = new JButton("Activate");
	    EmployeeController  = new EmployeeController();
		
	    btnActivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String UID;
				UID = textField.getText();
		
				EmployeeController.activateEmployee(UID);
				JOptionPane.showMessageDialog(frame, "Activated Successfully");
				
			}
			
		});
		btnActivateButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnActivateButton.setBounds(151, 146, 81, -13);
		frame.getContentPane().add(btnActivateButton);
		
		
		 btnActivateButton.setBackground(UIManager.getColor("Button.focus"));
		 btnActivateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnActivateButton.setBounds(151, 106, 99, 29);
		frame.getContentPane().add( btnActivateButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ActivateEmpFrame() throws ClassNotFoundException, SQLException {
		EmployeeActivation();
	}
}
