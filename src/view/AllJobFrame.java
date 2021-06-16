package view;

import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import config.JdbcConnection;

public class AllJobFrame extends JFrame {
	JFrame frame;
	Container container;
	public AllJobFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JdbcConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId","JobTitle", "JobDescription", "CompanyName", "Location","KeySkill","Salary","Activate"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Job");
		while(rst.next())
		{
		    
			int a = rst.getInt("JobId");
		    String b = rst.getString("JobTitle");
		    String c = rst.getString("JobDescription");
		    String d = rst.getString("CompanyName");
		    String e = rst.getString("Location");
		    String f = rst.getString("KeySkill");
		    String g = rst.getString("Salary");
		    //String h = rst.getString("Activate");
		    model.addRow(new Object[]{a,b,c,d,e,f,g});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Job Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	

}
