package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import model.dept.Dept;
import model.dept.GetDeptListLogic;


@WebFilter("/*")
public class MakeDeptListFilter extends HttpFilter implements Filter {


	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		GetDeptListLogic logic = new GetDeptListLogic();
		List<Dept> deptList = logic.execute();
		request.setAttribute("deptList", deptList);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
