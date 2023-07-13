package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmployeeLogic;


@WebServlet("/remove")
public class RemoveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DeleteEmployeeLogic logic = new DeleteEmployeeLogic();
		boolean result = logic.execute(id);
		
		String msg = "";
		if(result) {
			msg = "ID: " + id + " を削除しました。";
		} else {
			msg = "削除に失敗しました。";
		}
		request.setAttribute("msg", msg);
		String url ="/WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
