package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartServiceImpl;
import service.ICartService;

/**
 * Servlet implementation class ChangeQuantityServlet
 */
@WebServlet("/ChangeQuantityServlet")
public class ChangeQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeQuantityServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String email;

		HttpSession session = request.getSession();

		email = session.getAttribute("email").toString();
		int item_id, quantity;

		item_id = Integer.parseInt(request.getParameter("item_id"));
		quantity = Integer.parseInt(request.getParameter("quantity"));

		ICartService iCartService = new CartServiceImpl();

		iCartService.changeQuantity(email, item_id, quantity);
	}

}
