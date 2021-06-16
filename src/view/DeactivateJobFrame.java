package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.JobController;

import javax.swing.JButton;

public class DeactivateJobFrame {

	private JFrame frame;
	private JTextField textField;
	JobController jobController=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new DeactivateJobFrame();
					
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
	private void DeactivateJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 frame.setVisible(true);
		
		JLabel lblJobID = new JLabel("Enter Job ID");
		lblJobID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJobID.setBounds(31, 46, 85, 14);
		frame.getContentPane().add(lblJobID);
		
		textField = new JTextField();
		textField.setBounds(127, 41, 188, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDeactivateButton = new JButton("Deactivate");
        jobController=new JobController();
		
        btnDeactivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(textField.getText());
				jobController.deactivateJob(s);
			}
			
		});
		btnDeactivateButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeactivateButton.setBounds(127, 89, 128, 23);
		frame.getContentPane().add(btnDeactivateButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeactivateJobFrame() throws ClassNotFoundException, SQLException {
		DeactivateJob();
	}
}
