package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.JobController;
import controller.SkillController;

public class AddSkillFrame {

	private JFrame frame;
	private JTextField textField_4;
	private JTextField textField_5;
	private static SkillController skillcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new AddSkillFrame();
					
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
	private void AddSkill() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 203);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblSkillName = new JLabel("Skill Name");
		lblSkillName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSkillName.setBounds(47, 37, 68, 14);
		frame.getContentPane().add(lblSkillName);
		
		JLabel lblSkillDescription = new JLabel("Skill Description");
		lblSkillDescription.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSkillDescription.setBounds(47, 67, 99, 14);
		frame.getContentPane().add(lblSkillDescription);
		
		JButton btnSubmitButton = new JButton("Submit");
		skillcontroller = new SkillController();
		btnSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String j1,j2;
				j1=textField_5.getText();
				j2=textField_4.getText();
				skillcontroller.addSkill(j1,j2);
				frame=new JFrame();
				JOptionPane.showMessageDialog(frame,"Skill Added");
			}
			
		});
		btnSubmitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmitButton.setBounds(195, 117, 89, 23);
		frame.getContentPane().add(btnSubmitButton);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(195, 62, 162, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(195, 32, 162, 20);
		frame.getContentPane().add(textField_5);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AddSkillFrame() throws ClassNotFoundException, SQLException {
		AddSkill();
	}


}
