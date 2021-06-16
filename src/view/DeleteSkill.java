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
import controller.SkillController;
import model.Employee;
import model.Job;
import model.Skill;

import javax.swing.JButton;

public class DeleteSkill {

	private JFrame frame;
	private JTextField textField;
	Skill k = new Skill();
	Employee emp;
	
	private SkillController skillcontroller;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new DeleteJob();
				
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
	private void DeleteJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblDeleteJob = new JLabel("Delete Skill Frame");
		lblDeleteJob.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeleteJob.setBounds(121, 41, 204, 20);
		frame.getContentPane().add(lblDeleteJob);
		
		JLabel lblEnterJobId = new JLabel("Enter SkillId");
		lblEnterJobId.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEnterJobId.setBounds(66, 115, 84, 14);
		frame.getContentPane().add(lblEnterJobId);
		
		textField = new JTextField();
		textField.setBounds(169, 110, 144, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
			skillcontroller = new SkillController();
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int KID;
				KID = Integer.parseInt(textField.getText());
				skillcontroller.DeleteSkill(KID);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(66, 185, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new HRAFrame(emp);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(199, 187, 89, 23);
		frame.getContentPane().add(btnBack);
		}
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeleteSkill() throws ClassNotFoundException, SQLException {
		DeleteJob();
	}
}
