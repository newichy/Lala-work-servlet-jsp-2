package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String _age = request.getParameter("age");
		int age	= MyUtil.parseInt(_age);	// int型にキャスト＆もし入力値が数値でないとき -1を返す。
		Employee emp = new Employee(id,name,age);
		
		// 入力値チェック
		Validator validator = new Validator();
		List<String> errmsgList = validator.check(emp);
		String url = "";
		
		// エラーメッセージがあれば戻る
		if(errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			url ="/WEB-INF/jsp/newEmp.jsp";
			request.setAttribute("_age", _age);
		} else {
			url ="/WEB-INF/jsp/createConfirm.jsp";
		}
		
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
