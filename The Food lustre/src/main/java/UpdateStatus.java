//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet(name = "UpdateStatus",urlPatterns = "/UpdateStatus")
//public class UpdateStatus extends HttpServlet 
//{
//	private static final long serialVersionUID = 1L;
//	
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//    {
//    	int oid=Integer.parseInt(request.getParameter("oid"));
//    	int cid=Integer.parseInt(request.getParameter("cid"));
//    	String status=request.getParameter("status");
//    	try 
//    	{
//    		Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/butter","root","root");
//			
//			PreparedStatement ps= con.prepareStatement("update cart set status=? where cart_id=?");
//			ps.setString(1,status);
//			ps.setInt(2,cid);
//			ps.executeUpdate();
//			
//			PreparedStatement ps1= con.prepareStatement("select * from users inner join cart on cart.uid=users.uid where cart.cart_id=?");
//			ps1.setInt(1, cid);
//			ResultSet rs=ps1.executeQuery();
//			
//			if(rs.next())
//			{
//				Email em=new Email(rs.getString("email"),"Order Status","Dear "+rs.getString("username")+", Your order id "+oid+" has been "+rs.getString("status")+". Thank you");
//				em.sendEmail();
//			}
//			
//			response.sendRedirect("orders.jsp");
//          
//   		}
//    	catch (Exception e) 
//    	{
//		    System.out.println(e);
//		}
//	}
// 
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//    {
//		doGet(request, response);
//	}
//
//}
