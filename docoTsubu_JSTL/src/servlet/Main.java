package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

//	つぶやきを処理するコントローラ
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DBからつぶやきリストを取得してリクエストスコープに保存
		GetMutterListLogic gmll =new GetMutterListLogic();
		List<Mutter> mutterList = gmll.execute();
		request.setAttribute("mutterList", mutterList);
		
		// ログインしているか確認
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			// 未ログインの場合、デフォルトページにリダイレクト
			response.sendRedirect("/docoTsubu/");
		} else {
			// ログイン済の場合、フォワード
			String url = "/WEB-INF/jsp/main.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		// 入力値チェック
		if(text != null && text.length() != 0) {
			// セッションスコープからユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			// DBのつぶやきリストに追加
			Mutter	mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic pml = new PostMutterLogic();
			pml.execute(mutter);
			
		} else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		// つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic gmll = new GetMutterListLogic();
		List<Mutter> mutterList = gmll.execute();
		request.setAttribute("mutterList",mutterList);
		
		// メイン画面にフォワード
		String url = "/WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
