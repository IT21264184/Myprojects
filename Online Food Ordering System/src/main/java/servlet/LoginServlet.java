package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
			
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final?useSSL=false", "root", "leomord123");
			PreparedStatement pst = con.prepareStatement("select * from customer where email = ? and password = ?");
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				session.setAttribute("name", rs.getString("name"));
				dispatcher =request.getRequestDispatcher("index.jsp");
			}
			else if((username.equals("admin")&&password.equals("1234"))){
				dispatcher =request.getRequestDispatcher("/item-list.jsp");
			}
				
			else {
				request.setAttribute("status", "failed");
				dispatcher =request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
	}

}