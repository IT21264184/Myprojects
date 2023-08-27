package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String address = request.getParameter("address");
		String umobile = request.getParameter("contact");
		String upwd = request.getParameter("pass");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "leomord123");
			PreparedStatement pst = con.prepareStatement("insert into customer (email,password,name,phone,address) values(?,?,?,?,?)");
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			pst.setString(3, uname);
			pst.setString(4, umobile);
			pst.setString(5, address);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0) {
				request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		
		} catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
