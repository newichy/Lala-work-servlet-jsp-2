package servlet.dept.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.FindDeptByIdLogic;

@WebServlet("/updateDept")
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FindDeptByIdLogic logic = new FindDeptByIdLogic();
		Dept dept = logic.execute(id);
		request.setAttribute("dept", dept);
		String url = "/WEB-INF/jsp/dept/updateDept.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
