package test;

import java.util.List;

import model.GetMutterListLogic;
import model.Mutter;

public class GetMutterListLogicTest {

	public static void main(String[] args) {
		GetMutterListLogic logic = new GetMutterListLogic();
		List<Mutter> mutterList = logic.execute();
		
		for(Mutter mutter : mutterList) {
			/*
			System.out.print(mutter.getId() +" ");
			System.out.print(mutter.getUserName() +" ");
			System.out.print(mutter.getText() + "\n");
			*/
			// MutterクラスのtoString()をオーバーライドしてある！
			System.out.print(mutter.toString() + "\n");
		}	
	}
}