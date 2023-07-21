package model;

import java.util.List;

import dao.EmployeeDAO;

public class FindEmpListByNameLogic {
	public List<Employee> execute(String name) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findEmpListByName(name);
		return empList;
	}
}
