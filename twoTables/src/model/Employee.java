package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private String id;
	private String name;
	private int age;
	private Dept dept;
	
	public Employee() {}
	public Employee(String id, String name, int age, Dept dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
	
}
