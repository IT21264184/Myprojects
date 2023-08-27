package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Profile;
import service.IProfileService;
import service.ProfileServiceImpl;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String Email;

		HttpSession session = request.getSession();

		Email = session.getAttribute("email").toString();

		Profile profile = new Profile();

		IProfileService iProfileService = new ProfileServiceImpl();

		String status, address, name, email, phone;

		address = request.getParameter("address");
		name = request.getParameter("name");
		email = request.getParameter("email");
		phone = request.getParameter("phone");

		System.out.println(email);
		
		status = iProfileService.checkPhone(phone);

		if (status.equals("Enter a valid phone number")) {
			profile.setAddress(address);
			profile.setEmail(email);
			profile.setName(name);

			Email = iProfileService.updateProfileByEmail(Email, profile);
		} else {
			profile.setAddress(address);
			profile.setEmail(email);
			profile.setName(name);
			profile.setPhone(phone);

			Email = iProfileService.updateProfileByEmail(Email, profile);
		}

		session.setAttribute("email", Email);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String resp = new Gson().toJson(status);

		out.print(resp);
	}

}
