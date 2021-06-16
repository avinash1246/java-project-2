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
import controller.SkillController;

public class ActivateSkillFrame {

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
					 new ActivateSkillFrame();
					
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
	private void ActivateSkill() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 438, 196);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblSkillID = new JLabel("Enter Skill ID");
		lblSkillID.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSkillID.setBounds(28, 48, 86, 14);
		frame.getContentPane().add(lblSkillID);
		
		textField = new JTextField();
		textField.setBounds(147, 43, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnActivateButton = new JButton("Activate");
        skillController=new SkillController();
		
        btnActivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(textField.getText());
				skillController.activateSkill(s);
			}
			
		});
		btnActivateButton.setBackground(UIManager.getColor("Button.foreground"));
		btnActivateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActivateButton.setBounds(153, 96, 94, 23);
		frame.getContentPane().add(btnActivateButton);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ActivateSkillFrame() throws ClassNotFoundException, SQLException {
		ActivateSkill();
	}

}
