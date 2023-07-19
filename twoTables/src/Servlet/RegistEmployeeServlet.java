package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.PostEmployeeLogic;
import model.dept.Dept;
import model.dept.FindDeptByIdLogic;


@WebServlet("/regist")
public class RegistEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		
		FindDeptByIdLogic logic = new FindDeptByIdLogic();
		Dept dept = logic.execute(dept_id);
		Employee emp = new Employee(id,name,age,dept);
		
		
		PostEmployeeLogic pel = new PostEmployeeLogic();
		pel.execute(emp);
		
		request.setAttribute("msg", "登録しました。");
		
		String url ="/WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
