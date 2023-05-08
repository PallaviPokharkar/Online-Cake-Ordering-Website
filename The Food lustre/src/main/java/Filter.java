

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter( {"/payment.jsp","/AddToCart","/addProduct.jsp","/validatePayment","/AddMobile","/cart.jsp","/ordered.jsp"})
public class Filter implements javax.servlet.Filter
{

    public Filter() 
    {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		if(req.getSession().getAttribute("m")==null)
		{
			res.sendRedirect("login.jsp");
		}
	
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
