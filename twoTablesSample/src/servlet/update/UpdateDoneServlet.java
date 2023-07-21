package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmployeeLogic;
import model.dept.Dept;
import model.dept.FindDeptByIdLogic;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		FindDeptByIdLogic logic = new FindDeptByIdLogic();
		Dept dept = logic.execute(dept_id);
		Employee employee = new Employee(id, name, age, dept);
		
		UpdateEmployeeLogic updateLogic = new UpdateEmployeeLogic();
		if (updateLogic.execute(employee)) {
			request.setAttribute("msg", "更新しました。");
		} else {
			request.setAttribute("msg", "更新に失敗しました。");
		}
		String url = "/WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
