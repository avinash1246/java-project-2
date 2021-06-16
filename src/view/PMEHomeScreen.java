package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PMEHomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new PMEHomeScreen();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void PMEFrame() {
		frame = new JFrame("PME Home Screen");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(120, 100, 467, 419);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblPMEPortal = new JLabel("Welcome to PME Portal");
		lblPMEPortal.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPMEPortal.setBounds(120, 11, 191, 33);
		frame.getContentPane().add(lblPMEPortal);
		
		JButton btnAllSkills = new JButton("View All Skills");
		btnAllSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllSkillFrame();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnAllSkills.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAllSkills.setBounds(88, 93, 259, 23);
		frame.getContentPane().add(btnAllSkills);
		
		JButton btnAllJobs = new JButton("View All Jobs");
		btnAllJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAllJobs.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAllJobs.setBounds(88, 180, 259, 23);
		frame.getContentPane().add(btnAllJobs);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLogout.setBounds(173, 305, 87, 33);
		frame.getContentPane().add(btnLogout);
		
		JButton btnDeactivateJobs = new JButton("Deactivate Jobs");
		btnDeactivateJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeactivateJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeactivateJobs.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeactivateJobs.setBounds(88, 228, 259, 33);
		frame.getContentPane().add(btnDeactivateJobs);
		
		JButton btnAddSkill = new JButton("Add Skill");
		btnAddSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new AddSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddSkill.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAddSkill.setBounds(88, 59, 259, 23);
		frame.getContentPane().add(btnAddSkill);
		
		JButton btnAddJob = new JButton("Add Job");
		btnAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new AddJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddJob.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAddJob.setBounds(88, 146, 259, 23);
		frame.getContentPane().add(btnAddJob);
	}
	/**
	 * Create the application.
	 */
	public PMEHomeScreen() {
		PMEFrame();
	}
}
