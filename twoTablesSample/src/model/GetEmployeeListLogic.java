package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmployeeListLogic {
	public List<Employee> execute() {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findAll();
		return empList;
	}
}
