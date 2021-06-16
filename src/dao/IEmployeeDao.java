package dao;

import java.util.List;

import model.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(Employee emp);
	void updateEmployee(Employee emp);
	Employee deactivateEmployee(Employee emp);
	void activateEmployee(Employee emp);
	void deleteEmployee(Employee emp);
	Employee checkLogin(Employee emp);
	
	

}