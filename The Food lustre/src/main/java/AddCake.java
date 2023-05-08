

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/AddCake")
@MultipartConfig(maxFileSize = 9999999999L)
public class AddCake extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
           
    public AddCake() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String price=request.getParameter("price");
		Part part=request.getPart("image");
		InputStream is=part.getInputStream();
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/butter","root","root");
				PreparedStatement ps=con.prepareStatement("insert into cakes(name,description,price,image) values(?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,desc);
				ps.setString(3,price);
				ps.setBlob(4, is);
				ps.executeUpdate();
				response.sendRedirect("AddCake.jsp");
		
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
