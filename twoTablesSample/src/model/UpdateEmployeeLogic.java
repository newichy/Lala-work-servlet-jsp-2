package model;

import dao.EmployeeDAO;

public class UpdateEmployeeLogic {
	public boolean execute(Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.update(employee)) {
			System.out.println("更新成功");
			return true;
		} else {
			System.out.println("更新失敗");
			return false;
		}
	}
}
