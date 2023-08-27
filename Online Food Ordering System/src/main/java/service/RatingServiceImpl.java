package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ietf.jgss.Oid;

import model.Order;
import model.Profile;
import model.Rating;
import util.CommonConstants;
import util.DBConnectionUtil;

public class RatingServiceImpl implements IRatingService {

	private static Connection con;

	private static Statement st;

	private static PreparedStatement pst;

	private static ResultSet rs;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(RatingServiceImpl.class.getName());

	@Override
	public void saveRating(String email, int order_id, int item_id, int rate_num, String review) {
		// TODO Auto-generated method stub
		
		Rating rating = new Rating();
		
		rating.setOrder_id(order_id);
		rating.setItem_id(item_id);
		rating.setRate_num(rate_num);
		rating.setReview(review);
		
		con = DBConnectionUtil.getDBConnection();
		
		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_ADD_TO_RATE);

			pst.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			pst.setInt(CommonConstants.COLUMN_INDEX_TWO, rating.getOrder_id());
			pst.setInt(CommonConstants.COLUMN_INDEX_THREE, rating.getItem_id());
			pst.setInt(CommonConstants.COLUMN_INDEX_FOUR, rating.getRate_num());
			pst.setString(CommonConstants.COLUMN_INDEX_FIVE, rating.getReview());

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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public int[] checkRating(String email, ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		
		int order_id, item_id, chk_item_id = 0, chk_order_id = 0;
		int[] chk = new int[2];
		
		con = DBConnectionUtil.getDBConnection();
		
		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_CHECK_RATE);
			
			for(Order o:orderList) {
				order_id = o.getOrder_id();
				
				for(Integer i:o.getItem_id()) {
					item_id = i;
					
					pst.setString(CommonConstants.COLUMN_INDEX_ONE, email);
					pst.setInt(CommonConstants.COLUMN_INDEX_TWO, order_id);
					pst.setInt(CommonConstants.COLUMN_INDEX_THREE, item_id);
					
					rs = pst.executeQuery();
					
					if(rs.next() == true) {
						chk_item_id = i;
						chk_order_id = o.getOrder_id();
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
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		chk[0] = chk_order_id;
		chk[1] = chk_item_id;
		
		return chk;
	}

	
	public static void main(String[] args) {
		String email = "ab@gmail.com";
		int[] chk = new int[2];
		
		IRatingService iRatingService = new RatingServiceImpl();
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		IOrderService iOrderService = new OrderServiceImpl();
		
		orderList = iOrderService.getOrder(email);
		
		chk = iRatingService.checkRating(email, orderList);
	
		System.out.println(chk[0]);
		System.out.println(chk[1]);
	}

	@Override
	public ArrayList<Rating> getRatings(int item_id) {
		// TODO Auto-generated method stub
		

		IProfileService iProfileService = new ProfileServiceImpl();
		
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		
		con = DBConnectionUtil.getDBConnection();
		
		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_GET_RATING);
			
			pst.setInt(CommonConstants.COLUMN_INDEX_ONE, item_id);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Rating rating = new Rating();
				
				
				rating.setEmail(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				rating.setReview(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				rating.setRate_num(rs.getInt(CommonConstants.COLUMN_INDEX_THREE));
				
				ratings.add(rating);
			}
			
			for(Rating r:ratings) {
				Profile profile = new Profile();
				profile = iProfileService.getDetailsByEmail(r.getEmail());
				
				r.setName(profile.getName());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */

			try {
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return ratings;
	}
}
