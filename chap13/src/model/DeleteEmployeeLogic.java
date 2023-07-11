package model;

import dao.EmployeeDAO;

public class DeleteEmployeeLogic {
	public void execute(String id) {
		
		EmployeeDAO dao = new EmployeeDAO();
		 if (dao.remove(id)){
			 System.out.println("削除成功："+ id);
		 } else {
			 System.out.println("削除失敗："+ id);
		 }
	}
}
