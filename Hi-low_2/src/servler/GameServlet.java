package servler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// アプリケーションスコープの作成
		ServletContext application = this.getServletContext();
		// 基本データ型はスコープに保存できないのでInteger型に！
		Integer kotae = (int) Math.floor(Math.random() * 99) +1 ;
		System.out.println(kotae);
		application.setAttribute("kotae", kotae);
		
		String msg = "ゲーム開始！数値を入力してください。";
		request.setAttribute("msg", msg);
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		String msg ="";
		String _num = request.getParameter("num");
		if(_num == "") {
			msg ="数値を入力してください。";
		} else {
			System.out.println(_num);
			Integer num = Integer.parseInt(_num);
			
			// アプリケーションスコープから取り出し
			ServletContext application = this.getServletContext();
			Integer kotae = (Integer) application.getAttribute("kotae");
			
			if(num > kotae) {
				msg = "大きすぎます";
			} else if ( num < kotae ) {
				msg = "小さすぎます";
			} else {
				msg = "正解です！";
			}
		}
		
		request.setAttribute("msg", msg);
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
