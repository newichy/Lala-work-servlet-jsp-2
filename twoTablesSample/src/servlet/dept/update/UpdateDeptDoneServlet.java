package servlet.dept.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.UpdateDeptLogic;

@WebServlet("/updateDeptDone")
public class UpdateDeptDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Dept dept = new Dept(id, name);
		
		UpdateDeptLogic updateLogic = new UpdateDeptLogic();
		if (updateLogic.execute(dept)) {
			request.setAttribute("msg", "更新しました。");
		} else {
			request.setAttribute("msg", "更新に失敗しました。");
		}
		
		String url = "/WEB-INF/jsp/dept/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
