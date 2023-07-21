package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsAlreadyUsedIdLogic;
import model.dept.Dept;
import model.dept.IsAlreadyUsedDeptIdLogic;

public class Validator {
	public List<String> check(Employee emp){
		IsAlreadyUsedIdLogic isLogic = new IsAlreadyUsedIdLogic();
		List<String> errmsgList = new ArrayList<>();
		
			if(isEmpty(emp.getId())) {
				errmsgList.add("IDが未入力です");
			} else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
				errmsgList.add("IDの形式が不正です");	
			} else if ( isLogic.execute(emp.getId()) ) {
				errmsgList.add("登録済みのIDです");
			}
			
			if(isEmpty(emp.getName())) {
				errmsgList.add("名前が未入力です");
			} else if (emp.getName().length() > 30) {
				errmsgList.add("名前は30文字以内で入力してください");
			}
			
			if(isEmpty(emp.getId())) {
				errmsgList.add("年齢が未入力です");
			} else if(emp.getAge() < 0) {
				errmsgList.add("年齢の形式が不正です");
			}
			
			if(isEmpty(emp.getDept().getName())) {
				errmsgList.add("部署名が未入力です");
			} else if (!emp.getDept().getId().matches("^D[0-9]{2}$")) {
				errmsgList.add("部署IDの形式が不正です");	
			}
			IsAlreadyUsedDeptIdLogic deptLogic = new IsAlreadyUsedDeptIdLogic();
			if (!deptLogic.execute(emp.getDept().getId())) {
				errmsgList.add("その部署は存在していません。");
			}
			
			
		return errmsgList;
	}
	
	public List<String> check(Dept dept){
		IsAlreadyUsedDeptIdLogic isLogic = new IsAlreadyUsedDeptIdLogic();
		List<String> errmsgList = new ArrayList<>();
		
			if(isEmpty(dept.getId())) {
				errmsgList.add("部署IDが未入力です");
			} else if (!dept.getId().matches("^D[0-9]{2}$")) {
				errmsgList.add("部署IDの形式が不正です");	
			} else if ( isLogic.execute(dept.getId()) ) {
				errmsgList.add("登録済みの部署IDです");
			}
			
			if(isEmpty(dept.getName())) {
				errmsgList.add("部署名が未入力です");
			} else if (dept.getName().length() > 30) {
				errmsgList.add("部署名は30文字以内で入力してください");
			}
		return errmsgList;
	}
	
	private boolean isEmpty(String str) {
		if(str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
}
