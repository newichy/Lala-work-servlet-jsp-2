package model;

import dao.EmployeeDAO;

public class PostEmployeeLogic {
	public void execute(Employee emp) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.insert(emp)){
			 System.out.println("登録成功："+ emp.getId());
		 } else {
			 System.out.println("登録失敗："+ emp.getId());
		 }
	}
}
