package test;

import model.Mutter;
import model.PostMutterLogic;

public class PostMutterLogicTest {

	public static void main(String[] args) {
		Mutter mutter = new Mutter("浦島太郎","竜宮城きた。");
		PostMutterLogic	pml = new PostMutterLogic();
		pml.execute(mutter);
	}

}
