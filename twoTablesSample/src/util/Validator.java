package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsAlreadyUsedIdLogic;
import model.dept.Dept;
import model.dept.IsAlreadyUsedDeptIdLogic;

public class Validator {
	public List<String> check(Employee emp, boolean isNew) {
		List<String> errmsgList = new ArrayList<>();
		
		if (isEmpty(emp.getId())) {
			errmsgList.add("IDが未入力です。");
		} else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			errmsgList.add("IDの形式が不正です。");
		}
		if (isNew) {
			IsAlreadyUsedIdLogic logic = new IsAlreadyUsedIdLogic();
			if (logic.execute(emp.getId())) {
				errmsgList.add("そのIDは既に使われています。");
			}
		}
		
		if (isEmpty(emp.getName())) {
			errmsgList.add("名前が未入力です。");
		} else if (emp.getName().length() > 30) {
			errmsgList.add("名前が長すぎます。");
		}
		if (emp.getAge() < 0) {
			errmsgList.add("年齢の形式が不正です。");
		}
		
		IsAlreadyUsedDeptIdLogic deptLogic = new IsAlreadyUsedDeptIdLogic();
		if (!emp.getDept().getId().matches("^D[0-9]{2}$")) {
			errmsgList.add("部署の形式が不正です。");
		}
		if (!deptLogic.execute(emp.getDept().getId())) {
			errmsgList.add("そんな部署はありません。");
		}
		
		return errmsgList;
	}
	
	// 空文字チェック
	private boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	public List<String> check(Dept dept, boolean isNew) {
		List<String> errmsgList = new ArrayList<>();
		
		if (isEmpty(dept.getId())) {
			errmsgList.add("IDが未入力です。");
		} else if (!dept.getId().matches("^D[0-9]{2}$")) {
			errmsgList.add("IDの形式が不正です。");
		}
		if (isNew) {
			IsAlreadyUsedDeptIdLogic logic = new IsAlreadyUsedDeptIdLogic();
			if (logic.execute(dept.getId())) {
				errmsgList.add("そのIDは既に使われています。");
			}
		}
		
		if (isEmpty(dept.getName())) {
			errmsgList.add("部署名が未入力です。");
		} else if (dept.getName().length() > 30) {
			errmsgList.add("名前が長すぎます。");
		}
		
		return errmsgList;
	}
}
