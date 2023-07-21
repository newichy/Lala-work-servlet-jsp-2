package model;

import java.util.List;

import dao.EmployeeDAO;

public class FindEmpListByDeptIdLogic {
	public List<Employee> execute(String dept_id) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findEmpListByDeptId(dept_id);
		return empList;
	}
}
