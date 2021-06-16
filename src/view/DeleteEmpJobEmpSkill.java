package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeController;
import controller.SkillController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteEmpJobEmpSkill {

	private JFrame frame;
	private JTextField textField;
	EmployeeController empcontroller;
	SkillController skillcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmpJobEmpSkill window = new DeleteEmpJobEmpSkill();
					window.frame.setVisible(true);
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
	public DeleteEmpJobEmpSkill() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Delete EmpJob or EmpSkill");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(110, 45, 180, 21);
		frame.getContentPane().add(lblNewLabel_1);

		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(58, 115, 147, 34);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setBounds(195, 115, 139, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("EmpJob");
		empcontroller = new EmployeeController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EID;
				EID= Integer.parseInt(textField.getText());
				empcontroller.DeleteEmpJob(EID);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(58, 204, 115, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EmpSkill");
		empcontroller = new EmployeeController();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EID;
				EID= Integer.parseInt(textField.getText());
				empcontroller.DeleteEmpSkill(EID);
			}
			
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBounds(220, 204, 109, 28);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
