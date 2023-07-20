package model.dept;

import dao.DeptDAO;

public class PostDeptLogic {
	public void execute(Dept dept) {
		
		DeptDAO dao = new DeptDAO();
		 if (dao.insert(dept)){
			 System.out.println("登録成功："+ dept.getId());
		 } else {
			 System.out.println("登録失敗："+ dept.getId());
		 }
	}
}
