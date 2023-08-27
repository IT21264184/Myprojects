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

import model.Order;
import service.IOrderService;
import service.IRatingService;
import service.OrderServiceImpl;
import service.RatingServiceImpl;

/**
 * Servlet implementation class GetOrderServlet
 */
@WebServlet("/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOrderServlet() {
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
		int[] chk = new int[2];
		int oid, it_id;

		IRatingService iRatingService = new RatingServiceImpl();

		ArrayList<Order> orderList = new ArrayList<Order>();

		IOrderService iOrderService = new OrderServiceImpl();

		orderList = iOrderService.getOrder(email);

		chk = iRatingService.checkRating(email, orderList);

		oid = chk[0];
		it_id = chk[1];

//		for(Order o: orderList) {
//			ArrayList<Integer> item_id = o.getItem_id();
//			ArrayList<String> note = o.getNote();
//			ArrayList<String> item_name = o.getItem_name();
//			ArrayList<Double> item_price = o.getItem_price();
//			ArrayList<String> img_path = o.getImg_path();
//			
//			Integer[] item_ids = new Integer[item_id.size()];
//			item_ids = item_id.toArray(item_ids);
//			
//			String[] notes = new String[note.size()];
//			notes = note.toArray(notes);
//			
//			String[] item_names = new String[item_name.size()];
//			item_names = item_name.toArray(item_names);
//			
//			Double[] item_prices = new Double[item_price.size()];
//			item_prices = item_price.toArray(item_prices);
//			
//			String[] img_paths = new String[img_path.size()];
//			img_paths = img_path.toArray(img_paths);
//			
//			int i = 1;
//			
//			System.out.println(item_ids[0]);
//			System.out.println(item_names[0]);
//			System.out.println(notes[0]);
//			System.out.println(item_prices[0]);
//			System.out.println(img_paths[0]);
//			System.out.println();
//			
//			request.setAttribute("item_ids" + i, item_ids);
//			request.setAttribute("notes" + i, notes);
//			request.setAttribute("item_names" + i, item_names);
//			request.setAttribute("item_prices" + i, item_prices);
//			request.setAttribute("img_paths" + i, img_paths);
//			
//			i++;
//		}

		request.setAttribute("orderList", orderList);
		request.setAttribute("oid", oid);
		request.setAttribute("it_id", it_id);

		RequestDispatcher rd = request.getRequestDispatcher("/orders.jsp");
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
