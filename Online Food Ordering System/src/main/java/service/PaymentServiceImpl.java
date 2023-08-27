package service;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payment;
import util.CommonConstants;
import util.DBConnectionUtil;

public class PaymentServiceImpl implements IPaymentService {

	private static Connection con;

	private static Statement st1, st2;

	private static PreparedStatement pst;

	private static ResultSet rs;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PaymentServiceImpl.class.getName());

	@Override
	public void addPayment(String type, String cardNo, String ccv, String exp_date, String name) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		Payment payment = new Payment();

		payment.setCardNo(cardNo);
		payment.setCcv(ccv);
		payment.setExp_date(exp_date);
		payment.setName(name);
		payment.setType(type);

		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_ADD_PAYMENT);

			pst.setString(CommonConstants.COLUMN_INDEX_ONE, payment.getType());
			pst.setString(CommonConstants.COLUMN_INDEX_TWO, payment.getCardNo());
			pst.setString(CommonConstants.COLUMN_INDEX_THREE, payment.getCcv());
			pst.setString(CommonConstants.COLUMN_INDEX_FOUR, payment.getExp_date());
			pst.setString(CommonConstants.COLUMN_INDEX_FIVE, payment.getName());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (pst != null) {
					pst.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (st2 != null) {
					st2.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		// Set the date, time, address, phone of the order
//		Order order = new Order();
//
//		IOrderService iOrderService = new OrderServiceImpl();
//
//		order.setDate(java.time.LocalDate.now());
//
//		order.setTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME));
//					
//		order.setAddress(address);			
//					
//		order.setPhone(phone);		
//					
//		iOrderService.createOrder(email, order, payment.getPayment_id());
	}

	@Override
	public String checkCardNo(long cardNo) {
		// TODO Auto-generated method stub
		String status = "", number;

		number = String.valueOf(cardNo);

		if (number.length() != 12) {
			status = "Enter a valid card number";
		}

		return status;
	}

	@Override
	public String checkCvv(int cvv) {
		// TODO Auto-generated method stub
		String status = "", number;

		number = String.valueOf(cvv);

		if (number.length() != 3) {
			status = "Enter a valid cvv";
		}

		return status;
	}

	@Override
	public String encrypt(String data) {
		// TODO Auto-generated method stub
		char[] text = data.toCharArray();
		String encryptedText = "";

		for (char c : text) {
			c -= CommonConstants.KEY;
			
			encryptedText += c;
		}
		
		return encryptedText;
	}

	@Override
	public String decrypt(String data) {
		// TODO Auto-generated method stub
		char[] text = data.toCharArray();
		String decryptedText = "";

		for (char c : text) {
			c += CommonConstants.KEY;
			
			decryptedText += c;
		}
		
		return decryptedText;
	}
	
	
}
