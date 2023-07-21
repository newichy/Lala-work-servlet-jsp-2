package servlet.dept.delete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.GetDeptListLogic;

@WebServlet("/deptList")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetDeptListLogic logic = new GetDeptListLogic();
		List<Dept> deptList = logic.execute();
		request.setAttribute("deptList", deptList);
		String url = "/WEB-INF/jsp/dept/deptList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
