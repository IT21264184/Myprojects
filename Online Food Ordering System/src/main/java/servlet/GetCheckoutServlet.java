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
import util.CommonConstants;

/**
 * Servlet implementation class GetCheckoutServlet
 */
@WebServlet("/GetCheckoutServlet")
public class GetCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCheckoutServlet() {
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

		HttpSession session = request.getSession();

		email = session.getAttribute("email").toString();

		ArrayList<Cart> itemList = new ArrayList<Cart>();

		IProfileService iProfileService = new ProfileServiceImpl();

		Profile profile = new Profile();

		profile = iProfileService.getDetailsByEmail(email);

		ICartService iCartService = new CartServiceImpl();

		itemList = iCartService.getItems(email);

		iCartService.calculateSubTotal(itemList);

		request.setAttribute("profile", profile);
		request.setAttribute("itemList", itemList);
		request.setAttribute("subTotal", Cart.getSub_total());
		request.setAttribute("deliveryFee", CommonConstants.DELIVERY_FEE);
		request.setAttribute("tax", Cart.getTax());
		request.setAttribute("total", Cart.getTotal());

		RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
