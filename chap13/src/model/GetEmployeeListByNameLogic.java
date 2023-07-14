package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmployeeListByNameLogic {
	public List<Employee> execute(String name){
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findAllByName(name);
		return empList;
	}
}
