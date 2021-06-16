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
import controller.JobController;

import javax.swing.JButton;

public class JobIdFrame {

	private JFrame frame;
	private JTextField textField;
	private static JobController jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new JobIdFrame();
									
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
	private void JobID() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 174);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblJobID = new JLabel("Enter Job ID");
		lblJobID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJobID.setBounds(27, 47, 126, 14);
		frame.getContentPane().add(lblJobID);
		
		textField = new JTextField();
		textField.setBounds(163, 42, 158, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmitButton = new JButton("Submit");
		jobcontroller = new JobController();
		btnSubmitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int JID;
				JID = Integer.parseInt(textField.getText());
				jobcontroller.getJobById(JID);
			}
			
		});
		btnSubmitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmitButton.setBounds(163, 96, 89, 23);
		frame.getContentPane().add(btnSubmitButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public JobIdFrame() throws ClassNotFoundException, SQLException {
		JobID();
	}

}
