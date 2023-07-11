package model;

import dao.MutterDAO;

public class PostMutterLogic {

	
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);					// booleanが返ってくるので成否判定も作れる
	}
	
}
