package service;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cart;
import model.Order;
import util.CommonConstants;
import util.DBConnectionUtil;

public class OrderServiceImpl implements IOrderService {

	private static Connection con;

	private static Statement st1, st2, st3, st4;

	private static PreparedStatement pst1, pst2, pst3;

	private static ResultSet rs1, rs2, rs3;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(OrderServiceImpl.class.getName());

	@Override
	public void createOrder(String email, String address, String phone) {
		// TODO Auto-generated method stub
		
		int payment_id;
		
		Order order = new Order();
		
		order.setDate(java.time.LocalDate.now());
		order.setTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME));		
		order.setAddress(address);		
		order.setPhone(phone);		
		
		ArrayList<Cart> itemList = new ArrayList<Cart>();

		ArrayList<Integer> item_id = new ArrayList<Integer>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<String> item_name = new ArrayList<String>();
		ArrayList<Double> item_price = new ArrayList<Double>();
		ArrayList<String> img_path = new ArrayList<String>();

		ICartService iCartService = new CartServiceImpl();

		itemList = iCartService.getItems(email);

		iCartService.calculateSubTotal(itemList);

		for (Cart c : itemList) {
			item_id.add(c.getItem_id());
			item_name.add(c.getItem_name());
			item_price.add(c.getItem_price());
			img_path.add(c.getImg_path());
			quantity.add(c.getQuantity());
		}

		order.setItem_id(item_id);
		order.setItem_name(item_name);
		order.setItem_price(item_price);
		order.setImg_path(img_path);
		order.setQuantity(quantity);
		
		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_CREATE_ORDER);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, order.getDate().toString());
			pst1.setDouble(CommonConstants.COLUMN_INDEX_TWO, Cart.getTotal());
			pst1.setString(CommonConstants.COLUMN_INDEX_THREE, order.getTime());
			pst1.setString(CommonConstants.COLUMN_INDEX_FOUR, order.getAddress());
			pst1.setString(CommonConstants.COLUMN_INDEX_FIVE, order.getPhone());

			pst1.executeUpdate();

			st1 = con.createStatement();

			st1.executeUpdate(CommonConstants.QUERY_ID_REMOVE_CACHE);

			st2 = con.createStatement();

			rs1 = st2.executeQuery(CommonConstants.QUERY_ID_ORDER_ID);

			rs1.next();

			order.setOrder_id(rs1.getInt(CommonConstants.COLUMN_INDEX_ONE) - 1);

			// add data to item_order

			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_ADD_TO_ITEM_ORDER);

			for (Cart c : itemList) {
				pst1.setInt(CommonConstants.COLUMN_INDEX_ONE, c.getItem_id());
				pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, order.getOrder_id());
				pst1.setInt(CommonConstants.COLUMN_INDEX_THREE, c.getQuantity());
				pst1.setString(CommonConstants.COLUMN_INDEX_FOUR, email);
				pst1.setInt(CommonConstants.COLUMN_INDEX_FIVE, c.getItem_id());

				pst1.executeUpdate();
			}

			
			st3 = con.createStatement();
			
			st3.executeUpdate(CommonConstants.QUERY_ID_REMOVE_CACHE);

			st4 = con.createStatement();

			rs3 = st4.executeQuery(CommonConstants.QUERY_ID_PAYMENT_ID);

			rs3.next();

			payment_id = rs3.getInt(CommonConstants.COLUMN_INDEX_ONE) - 1;
			
			
			// add data to place table
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_ADD_TO_PLACE);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, payment_id);
			pst1.setInt(CommonConstants.COLUMN_INDEX_THREE, order.getOrder_id());

			pst1.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (pst1 != null) {
					pst1.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (st2 != null) {
					st2.close();
				}
				if (st3 != null) {
					st3.close();
				}
				if (st4 != null) {
					st4.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		// remove ordered items from the cart
		iCartService.clearAllItems(email);
	}

	
	@Override
	public ArrayList<Order> getOrder(String email) {
		// TODO Auto-generated method stub

		ArrayList<Order> orderList = new ArrayList<Order>();
		String decrypt_cardNo;
		IPaymentService iPaymentService = new PaymentServiceImpl();

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_GET_ORDERS);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);

			rs1 = pst1.executeQuery();

			while (rs1.next()) {

				Order order = new Order();

				order.setOrder_id(rs1.getInt(CommonConstants.COLUMN_INDEX_ONE));
				order.setDate(rs1.getDate(CommonConstants.COLUMN_INDEX_TWO).toLocalDate());
				order.setOrder_total(rs1.getDouble(CommonConstants.COLUMN_INDEX_THREE));
				order.setTime(rs1.getTime(CommonConstants.COLUMN_INDEX_FOUR).toString());
				order.setAddress(rs1.getString(CommonConstants.COLUMN_INDEX_FIVE));
				order.setPhone(rs1.getString(CommonConstants.COLUMN_INDEX_SIX));

				pst3 = con.prepareStatement(CommonConstants.QUERY_ID_GET_PAYMENT_FOR_OID);
				
				pst3.setInt(CommonConstants.COLUMN_INDEX_ONE, order.getOrder_id());
				
				rs3 = pst3.executeQuery();
				
				rs3.next();
				
				order.setPay_type(rs3.getString(CommonConstants.COLUMN_INDEX_ONE));
				
				if(order.getPay_type().equals("Credit/Debit Card")) {
					decrypt_cardNo = iPaymentService.decrypt(rs3.getString(CommonConstants.COLUMN_INDEX_TWO));
					
					String new_cardNo = decrypt_cardNo.substring(0, 4) + "****" + decrypt_cardNo.substring(9, 13);
					
					order.setCardNo(new_cardNo);
				}
				
				orderList.add(order);
			}

			for (Order o : orderList) {

				ArrayList<Integer> item_id = new ArrayList<Integer>();
				ArrayList<String> note = new ArrayList<String>();
				ArrayList<String> item_name = new ArrayList<String>();
				ArrayList<Double> item_price = new ArrayList<Double>();
				ArrayList<String> img_path = new ArrayList<String>();
				ArrayList<Integer> quantity = new ArrayList<Integer>();

				pst1 = con.prepareStatement(CommonConstants.QUERY_ID_GET_ITEMS);

				pst1.setInt(CommonConstants.COLUMN_INDEX_ONE, o.getOrder_id());

				rs1 = pst1.executeQuery();

				while (rs1.next()) {

					item_id.add(rs1.getInt(CommonConstants.COLUMN_INDEX_ONE));
					note.add(rs1.getString(CommonConstants.COLUMN_INDEX_TWO));
					quantity.add(rs1.getInt(CommonConstants.COLUMN_INDEX_THREE));
				}

				o.setItem_id(item_id);
				o.setNote(note);
				o.setQuantity(quantity);

				for (int i : item_id) {

					pst2 = con.prepareStatement(CommonConstants.QUERY_ID_GET_PRICE_IMG_NAME);

					pst2.setInt(CommonConstants.COLUMN_INDEX_ONE, i);

					rs2 = pst2.executeQuery();

					rs2.next();

					item_price.add(rs2.getDouble(CommonConstants.COLUMN_INDEX_ONE));
					img_path.add(rs2.getString(CommonConstants.COLUMN_INDEX_TWO));
					item_name.add(rs2.getString(CommonConstants.COLUMN_INDEX_THREE));
				}

				o.setImg_path(img_path);
				o.setItem_name(item_name);
				o.setItem_price(item_price);

//				System.out.println(o.getItem_id());
//				System.out.println(o.getItem_name());
//				System.out.println(o.getItem_price());
//				System.out.println(o.getNote());
//				System.out.println(o.getImg_path());
//				System.out.println();

//				Integer[] item_ids = new Integer[item_id.size()];
//				item_ids = item_id.toArray(item_ids);
//				
//				String[] notes = new String[note.size()];
//				notes = note.toArray(notes);
//				
//				String[] item_names = new String[item_name.size()];
//				item_names = item_name.toArray(item_names);
//				
//				Double[] item_prices = new Double[item_price.size()];
//				item_prices = item_price.toArray(item_prices);
//				
//				String[] img_paths = new String[img_path.size()];
//				img_paths = img_path.toArray(img_paths);
//				
//				for (int i = 0; i < item_ids.length; i++) {
//					System.out.println(item_ids[i]);
//					System.out.println(item_names[i]);
//					System.out.println(notes[i]);
//					System.out.println(item_prices[i]);
//					System.out.println(img_paths[i]);
//					System.out.println();
//					
//				}
				
				
				
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */

			try {
				if (pst1 != null) {
					pst1.close();
				}
				if (pst2 != null) {
					pst2.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return orderList;
	}

	
}
