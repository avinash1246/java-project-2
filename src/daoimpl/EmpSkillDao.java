package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JdbcConnection;

import dao.IEmpSkillDao;
import model.Empskill;

public class EmpSkillDao implements IEmpSkillDao {
	

	Connection conn = null;

	public EmpSkillDao() throws ClassNotFoundException, SQLException {	
		
		conn=JdbcConnection.getDBConnection();
	}


	@Override
	public void addEmpskill(Empskill esk) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into EmpSkill(EmployeeId,SkillId,ExpYear) values (?,?,?)");
			ps.setLong(1, esk.getEmpId());
			ps.setLong(2, esk.getSkillId());
			ps.setLong(3, esk.getExpYear());
			
			
			int i=ps.executeUpdate();
			JFrame j=new JFrame();
			if(i==1){
				
				JOptionPane.showConfirmDialog(j, "The Record has been Added Successfully...");
			}
			else {
				//System.out.println("deletion failed...");
				JOptionPane.showConfirmDialog(j, "Record Not Added...Retry..!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	
		

	@Override
	public void deleteEmpskill(Empskill emps) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where EmployeeId=? ");
			pst.setInt(1, emps.getEmpId());
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			if(i==1){
				//System.out.println("1 record deleted...");
				JOptionPane.showConfirmDialog(j, "The Record has been Deleted...");
			}
			else {
				//System.out.println("deletion failed...");
				JOptionPane.showConfirmDialog(j, "Record deletion Failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	
		
	}

}
