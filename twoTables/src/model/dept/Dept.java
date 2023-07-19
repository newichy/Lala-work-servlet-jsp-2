package model.dept;

import java.io.Serializable;

public class Dept implements Serializable {

	private String id;
	private String name;
	
	public Dept() {};
	public Dept(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}
}
