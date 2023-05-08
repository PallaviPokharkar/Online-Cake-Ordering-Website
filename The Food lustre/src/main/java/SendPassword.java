//
//
//import java.awt.print.Printable;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//
//@WebServlet("/SendPassword")
//public class SendPassword extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//    public SendPassword() {
//        super();
//        
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		PrintWriter out=response.getWriter();
//		String email=request.getParameter("email");
//	
//    	try {
//    		
//    		Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/butter","root","root");
//				
//				PreparedStatement ps = con.prepareStatement("select * from users where email=?");
//				ps.setString(1,email);
//				
//				ResultSet rs=ps.executeQuery();
//				if(rs.next())
//				{
//					Email em=new Email(email,"Your Password","Your Password is "+"password");
//					em.sendEmail();
//					response.sendRedirect("index.jsp");
//				}
//				else {
//					out.println(""
//							+ "<script>"
//							+ "alert('Eamil is not registered');"
//							+ "window.location='forgetPassword.jsp';"
//							+ "</script>");
//				}
//    
//    		
//				
//    	}catch(Exception e){
//    		System.out.println(e);
//    	}
//			
//		
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}
//
//}
