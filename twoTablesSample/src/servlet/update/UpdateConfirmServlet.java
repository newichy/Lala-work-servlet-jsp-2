package servlet.update;

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

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageTxt = request.getParameter("age");
		int age = MyUtil.parseInt(ageTxt);
		String dept_id = request.getParameter("dept_id");
		Dept dept = new Dept(dept_id, null);
		Employee employee = new Employee(id, name, age, dept);
		Validator validator = new Validator();
		// IDの使用済チェックをおこなわない
		List<String> errmsgList = validator.check(employee, false);
		
		String url = null;
		if (errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			request.setAttribute("ageTxt", ageTxt);
			url = "/WEB-INF/jsp/updateEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/updateConfirm.jsp";
		}
		request.setAttribute("employee", employee);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
