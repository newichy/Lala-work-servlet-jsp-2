package servlet.dept.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.PostDeptLogic;

@WebServlet("/registDept")
public class RegistDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Dept dept = new Dept(id, name);
		
		PostDeptLogic postLogic = new PostDeptLogic();
		if (postLogic.execute(dept)) {
			request.setAttribute("msg", "保存しました。");
		} else {
			request.setAttribute("msg", "保存に失敗しました。");
		}
		String url = "/WEB-INF/jsp/dept/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
