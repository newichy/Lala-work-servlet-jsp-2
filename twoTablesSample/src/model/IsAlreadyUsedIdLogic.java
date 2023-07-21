package model;

import dao.EmployeeDAO;

public class IsAlreadyUsedIdLogic {
	public boolean execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.isAlreadyUserdId(id);
	}
}
