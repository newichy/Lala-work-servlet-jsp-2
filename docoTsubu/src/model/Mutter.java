package model;

import java.io.Serializable;

// つぶやき情報を保持するデータモデルクラス
public class Mutter implements Serializable{
	
	private String userName;
	private String text;
	
	public Mutter() {}
	public Mutter(String userName, String text) {
		super();
		this.userName = userName;
		this.text = text;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
	
}
