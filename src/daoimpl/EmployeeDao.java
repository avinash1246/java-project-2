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
import dao.IEmployeeDao;
import model.Employee;


public class EmployeeDao implements IEmployeeDao {
	
	Connection conn=null;
	public EmployeeDao()throws ClassNotFoundException, SQLException{
		
		conn=JdbcConnection.getDBConnection();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Employee");
			if(rst!=null) {
				Employee emp=null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmpId(rst.getInt(8));
					emp.setFirstName(rst.getString(1));
					emp.setLastName(rst.getString(2));
					emp.setUserId(rst.getString(3));
					emp.setPassword(rst.getString(4));
					emp.setRole(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setActive(rst.getString(7));
					
					allEmpList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		return allEmpList;
		
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			
			//creating prepared statements object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Employee(FirstName, LastName, UserId, Password, Role, Gender) values (?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserId());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getRole());
			pst.setString(6, emp.getGender());
			
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

	public Employee getEmployeeById(Employee emp) {
		PreparedStatement ps;
		try {
			ps =conn.prepareStatement("select * from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs=ps.executeQuery();
			JFrame frame= new JFrame();
			JTable table= new JTable();
			DefaultTableModel model= new DefaultTableModel(new String [] {"EmpId","FirstName","LastName","UserID","Password","Role","Gender","Active"},0);
			         while(rs.next())
			         {
			        	 String a = rs.getString("FirstName");
			        	 String b = rs.getString("LastName");
			        	 String c = rs.getString("UserId");
			        	 String d = rs.getString("Password");
			        	 String e = rs.getString("Role");
			        	 String f = rs.getString("Gender");
			        	 String g = rs.getString("Active");
			        	 String h = rs.getString("EmpId");
			        	 model.addRow(new Object[] {a,b,c,d,e,f,g,h});
			        	 table.setModel(model);
			        	 JScrollPane sp = new JScrollPane();
			        	 frame.add(sp);
			        	 frame.add(table);
			        	 table.setBounds(10, 10, 500, 500);
			        	 frame.setVisible(true);
			        	 frame.setBounds(10, 10, 500, 500);
			        	 frame.setTitle("View EMP by ID");
			         }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	@Override
	public void updateEmployee(Employee emp) {
try {
			
			//creating prepared statements object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set FirstName=?, LastName=?,Password=? where UserId=?");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getPassword());
			pst.setString(4, emp.getUserId());
			
			int rs=pst.executeUpdate();
			JFrame f=new JFrame();
			if(rs==1){
				
				JOptionPane.showConfirmDialog(f, "updated successfully");
			
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
		
	}
		

	@Override
	public Employee deactivateEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from Employee where UserId=?");
			ps.setString(1, emp.getUserId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("update Employee set Active= 'No' where UserId=?");
					ps.setString(1, emp.getUserId());
					ps.executeUpdate();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
		
		
	}

	@Override
	public void activateEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select UserId from Employee where UserId=?");
			ps.setString(1, emp.getUserId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("update Employee set Active= 'yes' where UserId=?");
					ps.setString(1, emp.getUserId());
					ps.executeUpdate();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
			
		
	}

	public void deleteEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select EmpId from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("delete from Employee where EmpId=?");
					ps.setInt(1, emp.getEmpId());
					ps.execute();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
}
		

	@Override
    public Employee checkLogin(Employee emp) {
		//Employee emp=new Employee();
		try {
			PreparedStatement pst=conn.prepareStatement("select * from Employee where  UserId=? and Password=?");
			pst.setString(1, emp.getUserId());
			pst.setString(2, emp.getPassword());
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmpId(rst.getInt(8));
					emp.setFirstName(rst.getString(1));
					emp.setLastName(rst.getString(2));
					emp.setUserId(rst.getString(3));
					emp.setPassword(rst.getString(4));
					emp.setRole(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setActive(rst.getString(7));
					
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}



	

	
	}
		
		
	
	

