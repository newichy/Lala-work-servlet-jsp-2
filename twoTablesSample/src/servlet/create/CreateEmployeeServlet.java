package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import util.MyUtil;
import util.Validator;

@WebServlet("/new")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/newEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String ageTxt = request.getParameter("age");
		int age = MyUtil.parseInt(ageTxt);
		String dept_id = request.getParameter("dept_id");
		Dept dept = new Dept(dept_id, null);
		Employee employee = new Employee(id, name, age, dept);
		// 入力チェック
		Validator validator = new Validator();
		// true -- IDの使用済チェックをおこなう
		List<String> errmsgList = validator.check(employee, true);
		String url = "";
		if (errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			request.setAttribute("ageTxt", ageTxt);
			url = "/WEB-INF/jsp/newEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/createConfirm.jsp";
		}
		request.setAttribute("employee", employee);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
