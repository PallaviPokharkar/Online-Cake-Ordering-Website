

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Register() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		String cpassword=request.getParameter("cpsw");
		if(password.equals(cpassword))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/butter","root","root");
				PreparedStatement ps=con.prepareStatement("insert into users(username,email,password,role) values(?,?,?,?)");
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, password);
				ps.setNString(4, "user");
				int row=ps.executeUpdate();
				if(row>0){
					
					response.sendRedirect("login.jsp");
				}
				else {
					response.sendRedirect("register.jsp");
				}
		
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		else
		{
			response.getWriter().println("" 
					+ "<script>"
					+ "alert('password are same!!!');"
					+ "window.location='register.jsp';"
					+ "</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
