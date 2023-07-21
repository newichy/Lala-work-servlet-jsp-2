package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmployeeByIdLogic;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FindEmployeeByIdLogic logic = new FindEmployeeByIdLogic();
		Employee employee = logic.execute(id);
		request.setAttribute("employee", employee);
		String url = "/WEB-INF/jsp/updateEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
