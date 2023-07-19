package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsAlreadyUsedIdLogic;

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
		return errmsgList;
	}
	
	private boolean isEmpty(String str) {
		if(str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
}
