package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/*")
public class ForwardFilter extends HttpFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		
		String nameAdd = (String) request.getAttribute("name");
		nameAdd += "：後処理";
		System.out.println(nameAdd);
		
		request.setAttribute("name", nameAdd); // 効いてない
	}


	public void init(FilterConfig fConfig) throws ServletException {	}
	public void destroy() {	}

}
