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

import model.Favourite;
import service.FavouriteServiceImpl;
import service.IFavouriteService;

/**
 * Servlet implementation class GetFavouriteServlet
 */
@WebServlet("/GetFavouriteServlet")
public class GetFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFavouriteServlet() {
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

		ArrayList<Favourite> favouriteList = new ArrayList<Favourite>();

		IFavouriteService iFavouriteService = new FavouriteServiceImpl();

		favouriteList = iFavouriteService.getFavourites(email);

		request.setAttribute("favouriteList", favouriteList);

		RequestDispatcher rd = request.getRequestDispatcher("/favourites.jsp");

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
