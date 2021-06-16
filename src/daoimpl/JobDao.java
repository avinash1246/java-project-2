package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.JdbcConnection;
import dao.IJobDao;
import model.Job;

public class JobDao implements IJobDao{
	Connection conn = null;
	public JobDao() throws ClassNotFoundException, SQLException {
		conn = JdbcConnection.getDBConnection();
	}
	
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job j=null;
				while(rst.next()) {
					j=new Job();
					j.setJobId(rst.getInt(1));
					j.setJobTitle(rst.getString(2));
					j.setJobDescription(rst.getString(3));
					j.setCompanyName(rst.getString(4));
					j.setLocation(rst.getString(5));
					j.setKeySkill(rst.getString(6));
					j.setSalary(rst.getString(7));
					j.setActive(rst.getString(8));
					allJobList.add(j);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
		
	}
	@Override
	public void addJob(Job j) {
            try {
			
			//creating prepared statements object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Job(Jobtitle,Jobdescription,Companyname,Location,Keyskill,Salary) values (?,?,?,?,?,?)");
			pst.setString(1, j.getJobTitle());
			pst.setString(2, j.getJobDescription());
			pst.setString(3, j.getCompanyName());
			pst.setString(4, j.getLocation());
			pst.setString(5, j.getKeySkill());
			pst.setString(6, j.getSalary());
			
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 Record inserted.....");
				JOptionPane.showConfirmDialog(g, "You have successfully Added an Employee...");
			}
			else {
				//System.out.println("Insertion Failed.....");
				JOptionPane.showConfirmDialog(g, " Retry... Insertion Failed");
			}
		}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
				
			}
		
		
	}
	@Override
	public Job getJobById(Job j) {
		PreparedStatement ps;
		try {
			ps =conn.prepareStatement("select * from Job where JobId=?");
			ps.setInt(1, j.getJobId());
			ResultSet rs=ps.executeQuery();
			JFrame frame= new JFrame();
			JTable table= new JTable();
			DefaultTableModel model= new DefaultTableModel(new String [] {"JobId","JobTitle","JobDescription","CompanyName","Location","KeySkill","Salary","Active"},0);
			         while(rs.next())
			         {
			 					
			 					String a = rs.getString("JobTitle");
			 					String b = rs.getString("JobDescription");
			 					String c = rs.getString("CompanyName");
			 					String d = rs.getString("Location");
			 					String e = rs.getString("KeySkill");
			 					String f = rs.getString("Salary");
			 					String g = rs.getString("Active");
			 					String h = rs.getString("JobId");
			 					 model.addRow(new Object[] {a,b,c,d,e,f,g,h});
					        	 table.setModel(model);
					        	 JScrollPane sp = new JScrollPane();
					        	 frame.add(sp);
					        	 frame.add(table);
					        	 table.setBounds(10, 10, 700, 700);
					        	 frame.setVisible(true);
					        	 frame.setBounds(10, 10, 700, 700);
					        	 frame.setTitle("View Job by ID");
					         }
		             }
			 					 
			 			    catch (SQLException e) {
			                e.printStackTrace();
		            }
		                    return j;
		
	                }
		
		
	
	@Override
	public void updateJob(Job j) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateJob(Job j) {
		PreparedStatement ps;
		try {
			
					ps=conn.prepareStatement("update Job set Active= 'No' where JobId=?");
					ps.setInt(1, j.getJobId());
					ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void activateJob(Job j) {
		PreparedStatement ps;
		try {
			
					ps=conn.prepareStatement("update Job set Active= 'Yes' where JobId=?");
					ps.setInt(1, j.getJobId());
					ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteJob(Job j) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select JobId from Job where JobId=?");
			ps.setInt(1, j.getJobId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("delete from Job where JobId=?");
					ps.setInt(1, j.getJobId());
					ps.execute();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
		
	}


