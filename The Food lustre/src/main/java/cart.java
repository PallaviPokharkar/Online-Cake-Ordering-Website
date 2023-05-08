import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/AddToCart"})
public class cart implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		PrintWriter out=response.getWriter();
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		
		if(req.getSession().getAttribute("m")==null)
		{
			out.println(""
					+ "<script>"
					+ "alert('Login Required');"
					+ "window.location='login.jsp';"
					+ "</script>");
		}
		else
		{
			chain.doFilter(req, resp);
		}	
	}

}