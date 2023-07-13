package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmployeeLogic;


@WebServlet("/updateDone")
public class UpdateEmployeeDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Employee emp = new Employee(id,name,age);
		
		// アップデート用ロジッククラス
		UpdateEmployeeLogic pel = new UpdateEmployeeLogic();
		pel.execute(emp);
		
		request.setAttribute("msg", "更新しました。");
		
		String url ="/WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
