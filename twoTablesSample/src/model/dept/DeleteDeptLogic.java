package model.dept;

import dao.DeptDAO;

public class DeleteDeptLogic {
	public boolean execute(String id) {
		DeptDAO dao = new DeptDAO();
		if (dao.remove(id)) {
			System.out.println("削除成功");
			return true;
		} else {
			System.out.println("削除失敗");
			return false;
		}
	}
}
