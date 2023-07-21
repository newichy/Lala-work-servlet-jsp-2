package model;

import dao.EmployeeDAO;

public class PostEmployeeLogic {
	public boolean execute(Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.insert(employee)) {
			System.out.println("登録成功");
			return true;
		} else {
			System.out.println("登録失敗");
			return false;
		}
	}
}
