package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Cart;
import service.CartServiceImpl;
import service.ICartService;

/**
 * Servlet implementation class GetCartServlet
 */
@WebServlet("/GetCartServlet")
public class GetCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCartServlet() {
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
		double sub_total;
		String pageLink;

		pageLink = request.getParameter("pageLink");

		ArrayList<Cart> itemList = new ArrayList<Cart>();

		ICartService iCartService = new CartServiceImpl();

		itemList = iCartService.getItems(email);

		iCartService.calculateSubTotal(itemList);

		sub_total = Cart.getSub_total();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String resp = new Gson().toJson(itemList);

		out.print(resp);

		// request.setAttribute("itemList", itemList);
		// request.setAttribute("sub_total", sub_total);

		// RequestDispatcher rd = request.getRequestDispatcher(pageLink);
		// rd.forward(request, response);
	}
}
