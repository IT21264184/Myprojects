package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.IPaymentService;
import service.PaymentServiceImpl;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPaymentServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String status = "";
		long cardNo = 0;
		int ccv = 0;
		String exp_date;
		String name;
		String type = request.getParameter("type");
		String encrypt_cardNo, encrypt_ccv;
		
		IPaymentService iPaymentService = new PaymentServiceImpl();
		
		if(type.equals("Credit/Debit Card")) {
			
			try {
				cardNo = Long.parseLong(request.getParameter("cardNo"));
				status = iPaymentService.checkCardNo(cardNo);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				status = "Enter a valid card number";
			}
			
			try {
				ccv = Integer.parseInt(request.getParameter("ccv"));
				status = iPaymentService.checkCvv(ccv);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				if(status.isEmpty())
					status = "Enter a valid cvv";
				
			}
			
			exp_date = request.getParameter("exp_date");
			name = request.getParameter("name");
			
			if(status.equals("")) {
				encrypt_cardNo = iPaymentService.encrypt(Long.toString(cardNo));
				encrypt_ccv = iPaymentService.encrypt(Integer.toString(ccv));
				
				System.out.println(encrypt_cardNo);
				System.out.println(encrypt_ccv);
				
				iPaymentService.addPayment(type, encrypt_cardNo, encrypt_ccv, exp_date, name);
			}
			
		}
		else if(type.equals("COD")){
			
			iPaymentService.addPayment(type, null, null, null, null);
		}
		

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String resp = new Gson().toJson(status);
		
		out.print(resp);
		
		System.out.println(resp);
	}

}
