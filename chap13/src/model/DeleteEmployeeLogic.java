package model;

import dao.EmployeeDAO;

public class DeleteEmployeeLogic {
	public boolean execute(String id) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.remove(id)){
			 System.out.println("削除成功："+ id);
			 return true;
		 } else {
			 System.out.println("削除失敗："+ id);
			 return false;
		 }
	}
}
