package model.dept;

import dao.DeptDAO;

public class PostDeptLogic {
	public boolean execute(Dept dept) {
		DeptDAO dao = new DeptDAO();
		if (dao.insert(dept)) {
			System.out.println("登録成功");
			return true;
		} else {
			System.out.println("登録失敗");
			return false;
		}
	}
}
