package view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import config.JdbcConnection;

public class AllEmployeeFrame extends JFrame {
	JFrame frame;
	Container container;
	public AllEmployeeFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JdbcConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{ "FirstName", "LastName","UserID", "Password", "Role","Gender"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Employee");
		while(rst.next())
		{
		    
		    String a = rst.getString("FirstName");
		    String b = rst.getString("LastName");
		    String c = rst.getString("UserID");
		    String d = rst.getString("Password");
		    String e = rst.getString("Role");
		    String f = rst.getString("Gender");
		   
		    model.addRow(new Object[]{a,b,c,d,e,f});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Employee Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	

}
