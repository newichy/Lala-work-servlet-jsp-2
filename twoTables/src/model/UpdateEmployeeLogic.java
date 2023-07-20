package model;

import dao.EmployeeDAO;

public class UpdateEmployeeLogic {
	public void execute(Employee emp) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.update(emp)){
			 System.out.println("編集成功："+ emp.getId());
		 } else {
			 System.out.println("編集失敗："+ emp.getId());
		 }
	}
}
