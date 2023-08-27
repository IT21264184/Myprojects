package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Profile;
import service.CartServiceImpl;
import service.ICartService;
import service.IProfileService;
import service.ProfileServiceImpl;

/**
 * Servlet implementation class GetProfileServlet
 */
@WebServlet("/GetProfileServlet")
public class GetProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email;

		//HttpSession session = request.getSession();

		
			email = "ab@gmail.com";

			request.getParameter("email");

			Profile profile = new Profile();

			IProfileService iProfileService = new ProfileServiceImpl();

			profile = iProfileService.getDetailsByEmail(email);

			ArrayList<Cart> itemList = new ArrayList<Cart>();

			itemList = (ArrayList<Cart>) request.getAttribute("itemList");

			request.setAttribute("profile", profile);
			request.setAttribute("itemList", itemList);

			RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");

			rd.forward(request, response);

		

	}

}
