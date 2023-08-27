package servlet;
import model.Item;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemDAO itemDAO;   
    
    public void init() {
    	itemDAO = new ItemDAO();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
				
			case "/insert":
				insertItem(request,response);
				break;
				
			case "/delete":
				deleteItem(request, response);
				break;
				
			case "/edit":
				showEditForm(request,response);
				break;
				
			case "/update":
				updateItem(request, response);
				break;
				
			default:
				listItem(request, response);
				break;
			}
		}
		
		catch(SQLException ex) {
				throw new ServletException(ex);
			}
		}


	private void listItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List < Item > listItem = itemDAO.selectAllItems();
		request.setAttribute("listItem", listItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Item existingItem = itemDAO.selectItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
		dispatcher.forward(request, response);
	}
	private void insertItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String img = request.getParameter("image");
		
		Item newItem = new Item();
		newItem.setItemID(id);
		newItem.setItemName(name);
		newItem.setItemPrice(price);
		newItem.setItemImg(img);
		newItem.setItemDes(description);
		
		itemDAO.insertItem(newItem);
		response.sendRedirect("list");
	}
	
	private void updateItem(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String img = request.getParameter("image");
		
		Item book = new Item();
		book.setItemID(id);
		book.setItemName(name);
		book.setItemPrice(price);
		book.setItemImg(img);
		book.setItemDes(description);
		
		itemDAO.updateItem(book);
		response.sendRedirect("list");
	}


	private void deleteItem(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		itemDAO.deleteItems(id);
		response.sendRedirect("list");
		
	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
