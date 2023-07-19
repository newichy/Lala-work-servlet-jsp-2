package model.dept;

import dao.DeptDAO;

public class FindDeptByIdLogic {
	public Dept execute(String id) {
		Dept dept = new Dept();
		
		DeptDAO dao = new DeptDAO();
		dept = dao.findDeptById(id);
		
		return dept;
	}
}
