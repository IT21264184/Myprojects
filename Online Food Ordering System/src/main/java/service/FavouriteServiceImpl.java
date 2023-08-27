package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Favourite;
import util.CommonConstants;
import util.DBConnectionUtil;

public class FavouriteServiceImpl implements IFavouriteService {

	private static Connection con;

	private static Statement st;

	private static PreparedStatement pst1, pst2, pst3;

	private static ResultSet rs1, rs2, rs3;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(FavouriteServiceImpl.class.getName());

	@Override
	public String addFavourites(String email, int item_id) {
		// TODO Auto-generated method stub

		String status = "";
		
		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_ADD_FAVOURITE);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);
			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, item_id);

			try {
				pst1.executeUpdate();
				
				status = "Added to favourites";
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				
				status = "Item is already added to favourites";
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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return status;
	}

	@Override
	public ArrayList<Favourite> getFavourites(String email) {
		// TODO Auto-generated method stub

		ArrayList<Favourite> favouriteList = new ArrayList<Favourite>();

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_GET_FAVOURITES);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);

			rs1 = pst1.executeQuery();

			while (rs1.next()) {
				Favourite favourite = new Favourite();

				favourite.setItem_id(rs1.getInt(CommonConstants.COLUMN_INDEX_TWO));

				pst2 = con.prepareStatement(CommonConstants.QUERY_ID_GET_PRICE_IMG_NAME);

				pst2.setInt(CommonConstants.COLUMN_INDEX_ONE, favourite.getItem_id());

				rs2 = pst2.executeQuery();

				rs2.next();

				favourite.setItem_price(rs2.getDouble(CommonConstants.COLUMN_INDEX_ONE));
				favourite.setImg_path(rs2.getString(CommonConstants.COLUMN_INDEX_TWO));
				favourite.setItem_name(rs2.getString(CommonConstants.COLUMN_INDEX_THREE));

				pst3 = con.prepareStatement(CommonConstants.QUERY_ID_GET_ITEM_DESCRIPTION);

				pst3.setInt(CommonConstants.COLUMN_INDEX_ONE, favourite.getItem_id());

				rs3 = pst3.executeQuery();

				rs3.next();

				favourite.setItem_description(rs3.getString(CommonConstants.COLUMN_INDEX_ONE));

				favouriteList.add(favourite);
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
				if (pst3 != null) {
					pst3.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return favouriteList;
	}

	@Override
	public String removeFavourite(String email, int item_id) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		try {
			pst1 = con.prepareStatement(CommonConstants.QUERY_ID_REMOVE_FAVOURITE);

			pst1.setString(CommonConstants.COLUMN_INDEX_ONE, email);

			pst1.setInt(CommonConstants.COLUMN_INDEX_TWO, item_id);

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
		return "Item will be removed from favourites";

	}
}
