package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ApplyJobFrame {

	private JFrame frame;
	private JLabel lRecruited,lEmployeeId;
	private JTextField textField,textField1,textField2;
	JButton btnSubmit;
	EmployeeController employeecontroller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ApplyJobFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void ApplyFrame() throws ClassNotFoundException, SQLException {
		Employee emp = new Employee();
		frame = new JFrame("Applying Job");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.setBounds(100, 100, 451, 344);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); 
		
		lRecruited = new JLabel("Recruited(yes/no)");
		lRecruited.setFont(new Font("Calibri", Font.PLAIN, 14));
		lRecruited.setBounds(59, 78, 112, 17);
		frame.getContentPane().add(lRecruited);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setBounds(203, 76, 152, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lEmployeeId = new JLabel("Employee ID");
		lEmployeeId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lEmployeeId.setBounds(59, 127, 72, 17);
		frame.getContentPane().add(lEmployeeId);
		
		JLabel lblJobId = new JLabel("Job ID");
		lblJobId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblJobId.setBounds(59, 176, 72, 17);
		frame.getContentPane().add(lblJobId);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField1.setColumns(10);
		textField1.setBounds(203, 125, 152, 20);
		frame.getContentPane().add(textField1);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField2.setColumns(10);
		textField2.setBounds(203, 174, 152, 20);
		frame.getContentPane().add(textField2);
		
		btnSubmit = new JButton("SUBMIT");
		employeecontroller = new EmployeeController();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RE;
				int EID, JID;
				RE= textField.getText();
				EID= Integer.parseInt(textField1.getText());
				JID= Integer.parseInt(textField2.getText());
				employeecontroller.addEmpJob(RE,EID,JID);
				JOptionPane.showMessageDialog(frame,"Applied Succesfully");
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSubmit.setBounds(60, 234, 130, 23);
		frame.getContentPane().add(btnSubmit);
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(230, 234, 130, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EmployeeHomeScreen(emp);
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ApplyJobFrame() throws ClassNotFoundException, SQLException {
		ApplyFrame();
	}

}
