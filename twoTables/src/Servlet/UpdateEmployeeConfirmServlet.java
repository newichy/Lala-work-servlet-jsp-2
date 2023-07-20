package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import model.dept.FindDeptByIdLogic;
import util.MyUtil;
import util.Validator;


@WebServlet("/updateConfirm")
public class UpdateEmployeeConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String _age = request.getParameter("age");
		int age	= MyUtil.parseInt(_age);	// int型にキャスト＆もし入力値が数値でないとき -1を返す。
		String dept_id = request.getParameter("dept_id");
		FindDeptByIdLogic logic = new FindDeptByIdLogic();
		Dept dept = logic.execute(dept_id);
		Employee emp = new Employee(id,name,age,dept);
		
		// 入力値チェック
		Validator validator = new Validator();
		List<String> errmsgList = validator.check(emp);
		String url = "";
		
		// 必ずID重複エラーが発生するので、当該エラーを削除。
		errmsgList.remove("登録済みのIDです");
		
		// エラーメッセージがあれば戻る
		if(errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			url ="/WEB-INF/jsp/updateEmp.jsp";
			request.setAttribute("_age", _age);
		} else {
			url ="/WEB-INF/jsp/updateConfirm.jsp";
		}
		
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
