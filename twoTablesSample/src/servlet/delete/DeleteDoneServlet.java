package servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmployeeLogic;

@WebServlet("/deleteDone")
public class DeleteDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeleteEmployeeLogic logic = new DeleteEmployeeLogic();
		if (logic.execute(id)) {
			request.setAttribute("msg", "削除しました。");
		} else {
			request.setAttribute("msg", "削除に失敗しました。");
		}
		String url = "/WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
