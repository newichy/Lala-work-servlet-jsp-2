package Servlet.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import util.Validator;


@WebServlet("/newDept")
public class CreateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/dept/newDept.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Dept dept = new Dept(id,name);
		
		// 入力値チェック
		Validator validator = new Validator();
		List<String> errmsgList = validator.check(dept);
		String url = "";
		
		// エラーメッセージがあれば戻る
		if(errmsgList.size() > 0) {
			request.setAttribute("errmsgList", errmsgList);
			url ="/WEB-INF/jsp/dept/newDept.jsp";
		} else {
			url ="/WEB-INF/jsp/dept/createDeptConfirm.jsp";
		}
		
		request.setAttribute("dept", dept);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
