package servlet.dept.update;

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

@WebServlet("/updateDeptConfirm")
public class UpdateDeptConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Dept dept = new Dept(id, name);
		Validator validator = new Validator();
		// IDの使用済チェックをおこなわない
		List<String> errmsgList = validator.check(dept, false);
		
		String url = null;
		if (errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			url = "/WEB-INF/jsp/dept/updateDept.jsp";
		} else {
			url = "/WEB-INF/jsp/dept/updateDeptConfirm.jsp";
		}
		request.setAttribute("dept", dept);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
