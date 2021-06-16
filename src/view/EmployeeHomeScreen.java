package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import model.Employee;

public class EmployeeHomeScreen {

	private JFrame frame;
	Employee emp = new Employee();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EmployeeHomeScreen();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	private void Frame3() {
		frame = new JFrame("Employee Home Screen");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 444, 339);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblDashboard = new JLabel("Welcome to Dashboard");
		lblDashboard.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDashboard.setBounds(120, 30, 230, 20);
		frame.getContentPane().add(lblDashboard);
		
		JButton btnProfile = new JButton("View Profile");
		btnProfile.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewProfile(emp);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnProfile.setBackground(UIManager.getColor("Button.highlight"));
		btnProfile.setFont(new Font("Calibri", Font.BOLD, 14));
		btnProfile.setBounds(120, 70, 230, 20);
		frame.getContentPane().add(btnProfile);
		
		JButton btnUpdateProfile = new JButton("Update your Profile");
         btnUpdateProfile.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateProfile(emp);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdateProfile.setFont(new Font("Calibri", Font.BOLD, 14));
		btnUpdateProfile.setBounds(120, 110, 230, 20);
		frame.getContentPane().add(btnUpdateProfile);

		
		JButton btnApplyJob = new JButton("Apply for a Job");
		btnApplyJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ApplyJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnApplyJob.setFont(new Font("Calibri", Font.BOLD, 14));
		btnApplyJob.setBounds(120, 190, 230, 20);
		frame.getContentPane().add(btnApplyJob);
		
		
		
		
		JButton btnAllJob = new JButton("View All Job");
		btnAllJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAllJob.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAllJob.setBounds(120, 150, 230, 20);
		frame.getContentPane().add(btnAllJob);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogOut.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLogOut.setBounds(120, 230, 230, 20);
		frame.getContentPane().add(btnLogOut);
	}
	
	public EmployeeHomeScreen(Employee emp) throws ClassNotFoundException, SQLException {
		this.emp=emp;
		Frame3();
	}


}
