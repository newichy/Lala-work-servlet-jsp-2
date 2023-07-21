package model.dept;

import dao.DeptDAO;

public class UpdateDeptLogic {
	public boolean execute(Dept dept) {
		DeptDAO dao = new DeptDAO();
		if (dao.update(dept)) {
			System.out.println("更新成功");
			return true;
		} else {
			System.out.println("更新失敗");
			return false;
		}
	}
}
