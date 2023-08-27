package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Favourite;
import service.FavouriteServiceImpl;
import service.IFavouriteService;

/**
 * Servlet implementation class RemoveFavouriteServlet
 */
@WebServlet("/RemoveFavouriteServlet")
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavouriteServlet() {
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
		String status;

		int item_id = Integer.parseInt(request.getParameter("item_id"));

		IFavouriteService iFavouriteService = new FavouriteServiceImpl();

		status = iFavouriteService.removeFavourite(email, item_id);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String resp = new Gson().toJson(status);

		out.print(resp);

		// response.sendRedirect("GetFavouriteServlet");
	}

}
