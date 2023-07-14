package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeListByNameLogic;


@WebServlet("/name")
public class FindEmployeeByName extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		//	名前による検索ロジック
		GetEmployeeListByNameLogic logic = new GetEmployeeListByNameLogic();
		List<Employee> empList = logic.execute(name);
		
		request.setAttribute("empList", empList);
		
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
