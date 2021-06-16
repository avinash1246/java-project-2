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

import controller.JobController;

import javax.swing.JButton;

public class AddJobFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static JobController jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AddJobFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AddJobFrame() throws ClassNotFoundException, SQLException {
		 AddJob();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void  AddJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblJobTitle = new JLabel("JobTitle");
		lblJobTitle.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJobTitle.setBounds(22, 37, 68, 14);
		frame.getContentPane().add(lblJobTitle);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJobDescription.setBounds(22, 67, 99, 14);
		frame.getContentPane().add(lblJobDescription);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCompanyName.setBounds(22, 92, 99, 14);
		frame.getContentPane().add(lblCompanyName);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLocation.setBounds(22, 122, 68, 14);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblKeySkills = new JLabel("Key Skills");
		lblKeySkills.setFont(new Font("Calibri", Font.BOLD, 14));
		lblKeySkills.setBounds(22, 153, 68, 14);
		frame.getContentPane().add(lblKeySkills);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSalary.setBounds(22, 178, 46, 14);
		frame.getContentPane().add(lblSalary);
		
		textField = new JTextField();
		textField.setBounds(170, 32, 162, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 62, 162, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 87, 163, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 117, 162, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 148, 162, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(170, 173, 162, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmitButton = new JButton("Submit");
		jobcontroller = new JobController();
		btnSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String j1,j2,j3,j4,j5,j6;
				j1=textField.getText();
				j2=textField_1.getText();
				j3=textField_2.getText();
				j4=textField_3.getText();
				j5=textField_4.getText();
				j6=textField_5.getText();
				jobcontroller.addJob(j1,j2,j3,j4,j5,j6);
				frame=new JFrame();
				JOptionPane.showMessageDialog(frame,"Job Added");
			}
			
		});
		btnSubmitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmitButton.setBounds(167, 214, 89, 23);
		frame.getContentPane().add(btnSubmitButton);
	}

}
