import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ValidatePayment")
public class ValidatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidatePayment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int cartid =Integer.parseInt(request.getParameter("cartid"));
		String cardno=request.getParameter("cardno");
		String date=request.getParameter("expdate");
		String cvv=request.getParameter("cvv");
		int uid = ((Model)session.getAttribute("m")).getUid();

		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/butter","root","root");
			
				PreparedStatement ps=con.prepareStatement("insert into ordered(cart_id,payment_type,cardno,exp,cvv,uid) values(?,?,?,?,?,?)");
				ps.setInt(1, cartid);
				ps.setString(2, "card");
				ps.setString(3, cardno);
				ps.setString(4, date);
				ps.setString(5, cvv);
				ps.setInt(6, uid);
				int row=ps.executeUpdate();
				if(row>0){
					
					PreparedStatement ps1=con.prepareStatement("update cart set status='ordered' where cart_id="+cartid);
					ps1.executeUpdate();
					response.getWriter().println("" 
							+ "<script>"
							+ "alert('Orderded Placed successfully!!!');"
							+ "window.location='recipt.jsp?cid="+cartid+"';"
							+ "</script>");
				}
				else {
					response.getWriter().println(""
							+ "<script>"
							+ "alert('Payment credentials are wrong');"
							+ "window.location='cart.jsp';"
							+ "</script>");
				}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
