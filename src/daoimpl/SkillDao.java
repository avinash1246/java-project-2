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
import dao.ISkillDao;
import model.Job;
import model.Skill;

public class SkillDao implements ISkillDao{
	Connection conn = null;
	public SkillDao() throws ClassNotFoundException, SQLException {
		conn = JdbcConnection.getDBConnection();
	}
	
	@Override
	public List<Skill> getAllSkill() {
		List<Skill> allSkillList=new ArrayList<Skill>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Skill");
			if(rst!=null) {
				Skill k=null;
				while(rst.next()) {
					k=new Skill();
					k.setSkillId(rst.getInt(1));
					k.setSkillName(rst.getString(2));
					k.setSkillDescription(rst.getString(3));
					k.setActive(rst.getString(8));
					allSkillList.add(k);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
		
	}
	@Override
	public void addSkill(Skill k) {
            try {
			
			//creating prepared statements object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName,Skilldescription) values (?,?)");
			pst.setString(1, k.getSkillName());
			pst.setString(2, k.getSkillDescription());
			
			
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
	public Skill getSkillById(Skill k) {
		PreparedStatement ps;
		try {
			ps =conn.prepareStatement("select * from Skill where SkillId=?");
			ps.setInt(1, k.getSkillId());
			ResultSet rs=ps.executeQuery();
			JFrame frame= new JFrame();
			JTable table= new JTable();
			DefaultTableModel model= new DefaultTableModel(new String [] {"SkillId","SkillName","SkillDescription","Active"},0);
			         while(rs.next())
			         {
			        	        String a = rs.getString("SkillId");
			 					String b = rs.getString("SkillName");
			 					String c = rs.getString("SkillDescription");
			 					String d = rs.getString("Active");
			 					
			 					 model.addRow(new Object[] {a,b,c,d});
					        	 table.setModel(model);
					        	 JScrollPane sp = new JScrollPane();
					        	 frame.add(sp);
					        	 frame.add(table);
					        	 table.setBounds(10, 10, 700, 700);
					        	 frame.setVisible(true);
					        	 frame.setBounds(10, 10, 700, 700);
					        	 frame.setTitle("View Skill by ID");
					         }
		             }
			 					 
			 			    catch (SQLException e) {
			                e.printStackTrace();
		            }
		                    return k;
		
	                }
		
		
	
	@Override
	public void updateSkill(Skill Skill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateSkill(Skill k) {
		PreparedStatement ps;
		try {
			
					ps=conn.prepareStatement("update Skill set Active= 'No' where SkillId=?");
					ps.setInt(1, k.getSkillId());
					ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void activateSkill(Skill k) {
		PreparedStatement ps;
		try {
			
					ps=conn.prepareStatement("update Skill set Active= 'Yes' where SkillId=?");
					ps.setInt(1, k.getSkillId());
					ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSkill(Skill k) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select SkillId from Skill where SkillId=?");
			ps.setInt(1, k.getSkillId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("delete from Skill where SkillId=?");
					ps.setInt(1, k.getSkillId());
					ps.execute();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}


