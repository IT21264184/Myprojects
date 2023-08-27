package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IRatingService;
import service.RatingServiceImpl;

/**
 * Servlet implementation class AddRatingServlet
 */
@WebServlet("/AddRatingServlet")
public class AddRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email;
		
		HttpSession session = request.getSession();
		
		email = session.getAttribute("email").toString();
		
		String review;
		
		int order_id, item_id, rate_num;
		
		order_id =Integer.parseInt(request.getParameter("oid"));
		item_id = Integer.parseInt(request.getParameter("item_id"));
		rate_num = Integer.parseInt(request.getParameter("rate_num"));
		
		if(!request.getParameter("review").isEmpty()) {
			review = request.getParameter("review");
		}
		else {
			review = request.getParameter("def_review");
		}
		
		IRatingService iRatingService = new RatingServiceImpl();
		
		iRatingService.saveRating(email, order_id, item_id, rate_num, review);
	}

}
