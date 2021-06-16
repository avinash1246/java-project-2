package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import model.Employee;

import java.awt.SystemColor;

public class HRAFrame {

	private JFrame frame;
	Employee emp;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new HRAFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	private void HRAPortal() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 471, 595);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblHRA = new JLabel("Welcome to HRA Portal");
		lblHRA.setFont(new Font("Calibri", Font.BOLD, 18));
		lblHRA.setBounds(20, 11, 187, 27);
		frame.getContentPane().add(lblHRA);
		
		JButton btnEmployeeId = new JButton("View Employees by ID");
		btnEmployeeId.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						new EmployeeIDFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
			}	
		});
		btnEmployeeId.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEmployeeId.setBounds(104, 150, 187, 27);
		frame.getContentPane().add(btnEmployeeId);
		
		JButton btnActiveSkills = new JButton("Active Skills");
		btnActiveSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ActivateSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActiveSkills.setFont(new Font("Calibri", Font.BOLD, 14));
		btnActiveSkills.setBounds(104, 260, 187, 23);
		frame.getContentPane().add(btnActiveSkills);
		
		
		JButton btnDeactiveSkills = new JButton("Deactive Skills");
		btnDeactiveSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeactivateSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeactiveSkills.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeactiveSkills.setBounds(104, 222, 187, 27);
		frame.getContentPane().add(btnDeactiveSkills);
		
		JButton btnActiveJobs = new JButton("Active Jobs");
		btnActiveJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
					new ActivateJobFrame();	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		
		btnActiveJobs.setBackground(new Color(240, 240, 240));
		btnActiveJobs.setFont(new Font("Calibri", Font.BOLD, 14));
		btnActiveJobs.setBounds(104, 328, 187, 27);
		frame.getContentPane().add(btnActiveJobs);
		
		JButton btnDeactiveJobs = new JButton("Deactive Jobs");
		btnDeactiveJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
					new DeactivateJobFrame();	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		
		btnDeactiveJobs.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeactiveJobs.setBounds(102, 366, 187, 33);
		frame.getContentPane().add(btnDeactiveJobs);
		
		JButton btnDeactiveEmployees = new JButton("Deactivate Employees");
		 btnDeactiveEmployees.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new DeactivateEmployeeFrame(emp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		btnDeactiveEmployees.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeactiveEmployees.setBounds(102, 82, 189, 27);
		frame.getContentPane().add(btnDeactiveEmployees);
		
		JButton btnActiveUsers = new JButton("Activate Users");
		 btnActiveUsers.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmpFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		btnActiveUsers.setFont(new Font("Calibri", Font.BOLD, 14));
		btnActiveUsers.setBounds(104, 120, 187, 23);
		frame.getContentPane().add(btnActiveUsers);
		
		JButton btnViewAllSkills = new JButton("View all Skills");
		btnViewAllSkills.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllSkillFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnViewAllSkills.setFont(new Font("Calibri", Font.BOLD, 14));
		btnViewAllSkills.setBounds(104, 188, 187, 23);
		frame.getContentPane().add(btnViewAllSkills);
		
		JButton btnViewAllJobs = new JButton("View all Jobs");
		btnViewAllJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllJobFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnViewAllJobs.setFont(new Font("Calibri", Font.BOLD, 14));
		btnViewAllJobs.setBounds(104, 294, 187, 23);
		frame.getContentPane().add(btnViewAllJobs);
		
		JButton btnViewAllEmployees = new JButton("View all Employees");
		btnViewAllEmployees.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllEmployeeFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnViewAllEmployees.setFont(new Font("Calibri", Font.BOLD, 14));
		btnViewAllEmployees.setBounds(102, 48, 189, 23);
		frame.getContentPane().add(btnViewAllEmployees);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e)  {	
			try {
				new DeleteEmployee();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
   });
		btnDeleteEmployee.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeleteEmployee.setBounds(104, 410, 187, 23);
		frame.getContentPane().add(btnDeleteEmployee);
		
		JButton btnDeleteJob = new JButton("Delete Job");
		btnDeleteJob.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
						new DeleteJob();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	   });
		btnDeleteJob.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeleteJob.setBounds(104, 444, 187, 23);
		frame.getContentPane().add(btnDeleteJob);
		
		JButton btnDeleteSkills = new JButton("Delete Skills");
		btnDeleteSkills.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
						new DeleteSkill();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	   });
		btnDeleteSkills.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeleteSkills.setBounds(104, 478, 187, 23);
		frame.getContentPane().add(btnDeleteSkills);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
					frame.dispose();
					} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setBounds(104, 522, 187, 23);
		frame.getContentPane().add(btnNewButton);
	}
	/**
	 * Create the application.
	 */
	public HRAFrame(Employee emp) {
		this.emp = emp;
		HRAPortal();
	}
}
