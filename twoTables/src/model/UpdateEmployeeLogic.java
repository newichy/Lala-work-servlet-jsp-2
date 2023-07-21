package model;

import dao.EmployeeDAO;

public class UpdateEmployeeLogic {
	public boolean execute(Employee emp) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.update(emp)){
			 System.out.println("編集成功："+ emp.getId());
			 return true;
		 } else {
			 System.out.println("編集失敗："+ emp.getId());
			 return false;
		 }
	}
}
