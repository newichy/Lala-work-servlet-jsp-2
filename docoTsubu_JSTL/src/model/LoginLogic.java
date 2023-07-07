package model;

// ログイン可否判定ロジックモデルクラス

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {return true;}
		return false;
	}
}
