package model;

import dao.EmployeeDAO;

public class FindEmployeeByIdLogic {
	public Employee execute(String id) {
		Employee employee = new Employee();
		
		EmployeeDAO dao = new EmployeeDAO();
		employee = dao.findEmployeeById(id);
		
		return employee;
	}
}
