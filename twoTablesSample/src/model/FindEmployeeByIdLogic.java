package model;

import dao.EmployeeDAO;

public class FindEmployeeByIdLogic {
	public Employee execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findEmployeeById(id);
		return employee;
	}
}
