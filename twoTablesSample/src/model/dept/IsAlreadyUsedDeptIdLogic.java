package model.dept;

import dao.DeptDAO;

public class IsAlreadyUsedDeptIdLogic {
	public boolean execute(String id) {
		DeptDAO dao = new DeptDAO();
		return dao.isAlreadyUsedId(id);
	}
}
