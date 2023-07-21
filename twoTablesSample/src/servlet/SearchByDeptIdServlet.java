package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpListByDeptIdLogic;

@WebServlet("/findDept")
public class SearchByDeptIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id");
		FindEmpListByDeptIdLogic logic = new FindEmpListByDeptIdLogic();
		List<Employee> empList = logic.execute(dept_id);
		request.setAttribute("empList", empList);
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
