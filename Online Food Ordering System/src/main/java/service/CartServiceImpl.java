package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cart;
import model.Profile;
import util.CommonConstants;
import util.DBConnectionUtil;

public class CartServiceImpl implements ICartService {

	private static Connection con;

	private static Statement st;

	private static PreparedStatement pst1, pst2;

	private static ResultSet rs1, rs2;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CartServiceImpl.class.getName());

	@Override
	public ArrayList<Cart> getItems(String email) {
		// TODO Auto-generated method stub

		ArrayList<Cart> itemList = new ArrayList<Cart>();

		con = DBConnectionUtil.getDBConnection();

		try {

			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_ALL_CART);

			pst1.setString(1, email);

			rs1 = pst1.executeQuery();

			while (rs1.next()) {
				Cart item = new Cart();

				item.setQuantity(rs1.getInt(CommonConstants.COLUMN_INDEX_THREE));
				item.setItem_id(rs1.getInt(CommonConstants.COLUMN_INDEX_TWO));

				pst2 = con.prepareStatement(CommonConstants.QUERY_ID_GET_PRICE_IMG_NAME);

				pst2.setInt(CommonConstants.COLUMN_INDEX_ONE, item.getItem_id());

				rs2 = pst2.executeQuery();

				rs2.next();

				item.setItem_price(rs2.getDouble(CommonConstants.COLUMN_INDEX_ONE));
				item.setImg_path(rs2.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setItem_name(rs2.getString(CommonConstants.COLUMN_INDEX_THREE));

				itemList.add(item);
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

		return itemList;
	}

	@Override
	public void clearAllItems(String email) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_CLEAR_CART);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);

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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}

	@Override
	public void clearSpecificItem(String email, int id) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_CLEAR_SPECIFIC_CART);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);

			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, id);

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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}

	@Override
	public void calculateSubTotal(ArrayList<Cart> itemList) {
		// TODO Auto-generated method stub

		int quantity;
		double price, sub_total = 0;

		for (Cart cart : itemList) {
			quantity = cart.getQuantity();
			price = cart.getItem_price();

			sub_total += quantity * price;
		}

		Cart.setSub_total(sub_total);
		Cart.setTax(CommonConstants.TAX_RATE * Cart.getSub_total());
		Cart.setTotal(Cart.getSub_total() + Cart.getTax() + CommonConstants.DELIVERY_FEE);
	}

	@Override
	public void changeQuantity(String email, int item_id, int quantity) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_CHANGE_QUANTITY);

			pst1.setInt(CommonConstants.COLUMN_INDEX_ONE, quantity);

			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, item_id);

			pst1.setString(CommonConstants.COLUMN_INDEX_THREE, email);

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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public String addToCart(String email, int item_id, int quantity, String notes) {
		// TODO Auto-generated method stub
		
		Cart cart = new Cart();
		
		cart.setItem_id(item_id);
		cart.setQuantity(quantity);
		cart.setNotes(notes);
		
		con = DBConnectionUtil.getDBConnection();
		
		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_ADD_TO_CART);
			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, item_id);
			pst1.setInt(CommonConstants.COLUMN_INDEX_THREE, quantity);
			pst1.setString(CommonConstants.COLUMN_INDEX_FOUR, notes);
			
			try {
				pst1.executeUpdate();
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				
				ArrayList<Cart> itemList = new ArrayList<Cart>();
				
				ICartService iCartService = new CartServiceImpl();
				
				itemList = iCartService.getItems(email);
				
				int qty;
				
				for(Cart c : itemList) {
					if(c.getItem_id() == cart.getItem_id()) {
						
						qty = cart.getQuantity() + c.getQuantity();
						
						iCartService.changeQuantity(email, cart.getItem_id(), qty);
					}
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */

			try {
				if (pst1 != null) {
					pst1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return "Added to cart successfully";
	}
}
