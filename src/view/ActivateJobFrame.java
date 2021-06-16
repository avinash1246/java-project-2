package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import controller.JobController;



public class ActivateJobFrame {

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
					new ActivateJobFrame();
					
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
	private void ActivateJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 443, 192);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblJobID = new JLabel("Enter  the Job ID");
		lblJobID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJobID.setBounds(44, 48, 121, 18);
		frame.getContentPane().add(lblJobID);
		
		textField = new JTextField();
		textField.setBounds(196, 45, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnActivateButton = new JButton("Activate");
       
			jobController=new JobController();
		
        btnActivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(textField.getText());
				jobController.activateJob(s);
			}
			
		});
		btnActivateButton.setBackground(UIManager.getColor("Button.foreground"));
		btnActivateButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnActivateButton.setBounds(126, 98, 104, 23);
		frame.getContentPane().add(btnActivateButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ActivateJobFrame() throws ClassNotFoundException, SQLException {
		ActivateJob();
	}


}
