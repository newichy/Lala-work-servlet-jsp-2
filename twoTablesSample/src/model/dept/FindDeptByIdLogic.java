package model.dept;

import dao.DeptDAO;

public class FindDeptByIdLogic {
	public Dept execute(String id) {
		DeptDAO dao = new DeptDAO();
		Dept dept = dao.findDeptById(id);
		return dept;
	}
}
