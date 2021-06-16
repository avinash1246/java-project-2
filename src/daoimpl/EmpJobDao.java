package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JdbcConnection;
import dao.IEmpJobDao;
import model.Empjob;

public class EmpJobDao implements IEmpJobDao {
	
	
Connection conn = null;
	

	public EmpJobDao() throws ClassNotFoundException, SQLException {	
	
		conn=JdbcConnection.getDBConnection();
	}



	@Override
	public void addEmpJob(Empjob empj) {
		
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("insert into EmpJob(EmployeeId,JobId,Recruited) values (?,?,?)");
				ps.setLong(1, empj.getEmpId());
				ps.setLong(2, empj.getJobId());
				ps.setString(3, empj.getRecruited());
				
				ps.executeUpdate();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}


	@Override
	public void deleteEmpJob(Empjob empj) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select EmployeeId from Empjob where EmployeeId=?");
			ps.setInt(1, empj.getEmpId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) { 
				if(rs.next()) {
				ps = conn.prepareStatement("delete from EmpJob where EmployeeId=?");
				ps.setInt(1, empj.getEmpId());
				ps.execute();
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}
