package model.dept;

import java.util.List;

import dao.DeptDAO;

public class GetDeptListLogic {
	public List<Dept> execute() {
		DeptDAO dao = new DeptDAO();
		List<Dept> deptList = dao.findAll();
		return deptList;
	}
}
