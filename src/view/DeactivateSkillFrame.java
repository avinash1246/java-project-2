package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.JobController;
import controller.SkillController;

public class DeactivateSkillFrame {

	private JFrame frame;
	private JTextField textField;
	SkillController skillController=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new DeactivateSkillFrame();
					
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
	private void  DeactivateSkill() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 443, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEnterSkillId = new JLabel("Enter Skill ID");
		lblEnterSkillId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterSkillId.setBounds(53, 47, 85, 14);
		frame.getContentPane().add(lblEnterSkillId);
		
		JButton btnDeactivateButton = new JButton("Deactivate");
        skillController=new SkillController();
		
        btnDeactivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(textField.getText());
				skillController.deactivateSkill(s);
			}
			
		});
		btnDeactivateButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeactivateButton.setBounds(149, 90, 128, 23);
		frame.getContentPane().add(btnDeactivateButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 42, 188, 20);
		frame.getContentPane().add(textField);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeactivateSkillFrame() throws ClassNotFoundException, SQLException {
		 DeactivateSkill();
	}


}
