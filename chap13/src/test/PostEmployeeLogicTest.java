package test;

import model.Employee;
import model.PostEmployeeLogic;

public class PostEmployeeLogicTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP999","KINTARO",99);
		PostEmployeeLogic pel = new PostEmployeeLogic();
		pel.execute(emp);
	}

}
