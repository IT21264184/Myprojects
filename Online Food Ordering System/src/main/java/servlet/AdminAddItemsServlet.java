package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemDAO;

/**
 * Servlet implementation class AdminAddItemsServlet
 */
@WebServlet("/AdminAddItemsServlet")
public class AdminAddItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ItemDAO itemDAO = new ItemDAO();
		
		
		
		int id =Integer.parseInt(request.getParameter("item_id"));
		String desc = request.getParameter("desc");
		String name = request.getParameter("name");
		double price =Double.parseDouble(request.getParameter("price"));
		String img = request.getParameter("img");
		
		itemDAO.addItems(id, desc, name, price, img);
	
		
		response.sendRedirect("http://localhost:8080/Online_food_ordering_system/AdminSerrvlet");
	}

}
