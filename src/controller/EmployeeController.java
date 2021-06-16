package controller;



import java.sql.SQLException;
import java.util.List;

import daoimpl.EmpJobDao;
import daoimpl.EmpSkillDao;
import daoimpl.EmployeeDao;
import model.Empjob;
import model.Employee;
import model.Empskill;

public class EmployeeController {
	
	EmployeeDao empDao=null;
	EmpSkillDao empskillDao=null;
	EmpJobDao empjobDao=null;
	
	public EmployeeController() throws ClassNotFoundException, SQLException{
		empDao = new EmployeeDao();
		empjobDao =  new EmpJobDao();
		empskillDao = new EmpSkillDao();
	}
	public Employee checkLogin(String userId, String password) {
		
		Employee emp = new Employee();
		emp.setUserId(userId);
		emp.setPassword(password);
		empDao.checkLogin(emp); 
		return emp;
	}
	
	public void addEmployee(String UFN,String ULN,String UID,String UP,String UG,String UR) {
		Employee emp= new Employee();
		emp.setFirstName(UFN);
		emp.setLastName(ULN);
		emp.setUserId(UID);
		emp.setPassword(UP);
		emp.setRole(UR);
		emp.setGender(UG);
		
		empDao.addEmployee(emp);
		}
	
   public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
   
   public Employee activateEmployee(String UID) {
	   Employee emp= new Employee();
	   emp.setUserId(UID);
	   empDao.activateEmployee(emp);
	   return emp;
   }
   
   public Employee deactivateEmployee(String UID) {
	   Employee emp= new Employee();
	   emp.setUserId(UID);
	   empDao.deactivateEmployee(emp);
	   return emp;
   }

   
   public Employee getEmployeeById(int id) {
	   Employee emp=new Employee();
	   emp.setEmpId(id);
	   empDao.getEmployeeById(emp);
	   return emp;
   }
   
   public Employee updateEmployee(String UFN,String ULN,String UP,String UID) {
	   Employee emp = new Employee();
	   emp.setFirstName(UFN);
	   emp.setLastName(ULN);
	   emp.setPassword(UP);
	   emp.setUserId(UID);
	   empDao.updateEmployee(emp);
	   return emp;
   }
   public Employee DeleteEmployee(int EID) {
	   Employee emp= new Employee();
	   emp.setEmpId(EID);
	   empDao.deleteEmployee(emp);
	   return emp;
   }
   	
   public void addEmpJob(String RE,int EID, int JID) {
		Empjob ejb=new Empjob();
		ejb.setRecruited(RE);
		ejb.setEmpId(EID);
		ejb.setJobId(JID);
		
		empjobDao.addEmpJob(ejb);
	}
	
	public Empjob DeleteEmpJob(int EID) {
		Empjob ejb= new Empjob();
		ejb.setEmpId(EID);
		empjobDao.deleteEmpJob(ejb);
		return ejb;
	}
	
	public void addEmpSkill(int EID, int SID, int EYR) {
		Empskill esk=new Empskill();
		esk.setEmpId(EID);
		esk.setSkillId(SID);
		esk.setExpYear(EYR);
		
		empskillDao.addEmpskill(esk);
	}
	
	public Empskill DeleteEmpSkill(int EID) {
		Empskill esl= new Empskill();
		esl.setEmpId(EID);
		empskillDao.deleteEmpskill(esl);
		return esl;
	}
	
}
   

   
   

