package model;

import dao.EmployeeDAO;

public class PostEmployeeLogic {
	public boolean execute(Employee emp) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.insert(emp)){
			 System.out.println("登録成功："+ emp.getId());
			 return true;
		 } else {
			 System.out.println("登録失敗："+ emp.getId());
			 return false;
		 }
	}
}
