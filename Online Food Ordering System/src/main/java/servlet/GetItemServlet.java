package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.Rating;
import service.IItemService;
import service.IRatingService;
import service.ItemServiceImpl;
import service.RatingServiceImpl;

/**
 * Servlet implementation class GetItemServlet
 */
@WebServlet("/GetItemServlet")
public class GetItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int item_id;
		Item item = new Item();
		
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		
		IRatingService iRatingService = new RatingServiceImpl();
		
		item_id =Integer.parseInt(request.getParameter("item_id"));
		
		ratings = iRatingService.getRatings(item_id);
		
		IItemService iItemService = new ItemServiceImpl();
		
		item = iItemService.getItem(item_id);
		
		request.setAttribute("item", item);
		request.setAttribute("ratings", ratings);
								
		RequestDispatcher rd = request.getRequestDispatcher("/itemPage.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
