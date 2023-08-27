package service;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Profile;
import util.CommonConstants;
import util.DBConnectionUtil;

public class ProfileServiceImpl implements IProfileService {
	private static Connection con;

	private static Statement st;

	private static PreparedStatement pst;

	private static ResultSet rs;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ProfileServiceImpl.class.getName());

	@Override
	public Profile getDetailsByEmail(String email) {
		// TODO Auto-generated method stub

		Profile profile = new Profile();

		con = DBConnectionUtil.getDBConnection();

		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_GET_CUSTOMER);

			pst.setString(1, email);

			rs = pst.executeQuery();

			rs.next();

			profile.setAddress(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
			profile.setEmail(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
			profile.setName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
			profile.setPhone(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));

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

		return profile;
	}

	@Override
	public String updateProfileByEmail(String Email, Profile profile) {
		// TODO Auto-generated method stub

		String new_email = Email;

		con = DBConnectionUtil.getDBConnection();

		try {
			
			if (profile.getAddress() != null && !profile.getAddress().isEmpty()) {
				pst = con.prepareStatement(CommonConstants.QUERY_ID_UPDATE_CUSTOMER_ADDRESS);

				pst.setString(CommonConstants.COLUMN_INDEX_ONE, profile.getAddress());
				pst.setString(CommonConstants.COLUMN_INDEX_TWO, Email);

				pst.executeUpdate();

			}
			if (profile.getName() != null && !profile.getName().isEmpty()) {
				pst = con.prepareStatement(CommonConstants.QUERY_ID_UPDATE_CUSTOMER_NAME);

				pst.setString(CommonConstants.COLUMN_INDEX_ONE, profile.getName());
				pst.setString(CommonConstants.COLUMN_INDEX_TWO, Email);

				pst.executeUpdate();

			}
			if (profile.getPhone() != null && !profile.getPhone().isEmpty()) {
				pst = con.prepareStatement(CommonConstants.QUERY_ID_UPDATE_CUSTOMER_PHONE);

				pst.setString(CommonConstants.COLUMN_INDEX_ONE, profile.getPhone());
				pst.setString(CommonConstants.COLUMN_INDEX_TWO, Email);

				pst.executeUpdate();

			}
			if (profile.getEmail() != null && !profile.getEmail().isEmpty()) {
				pst = con.prepareStatement(CommonConstants.QUERY_ID_UPDATE_CUSTOMER_EMAIL);

				pst.setString(CommonConstants.COLUMN_INDEX_ONE, profile.getEmail());
				pst.setString(CommonConstants.COLUMN_INDEX_TWO, Email);

				pst.executeUpdate();
				
				new_email = profile.getEmail();
			}
			
			
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

		return new_email;
	}

	@Override
	public void deleteProfileByEmail(String email) {
		// TODO Auto-generated method stub

		con = DBConnectionUtil.getDBConnection();

		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_DELETE_CUSTOMER);

			pst.setString(CommonConstants.COLUMN_INDEX_ONE, email);

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
	public String checkPhone(String phone) {
		// TODO Auto-generated method stub

		String status = "";
		long number;

		if (phone.length() != 0) {
			try {
				number = Long.parseLong(phone);

				if (phone.length() != 10) {
					status = "Enter a valid phone number";
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				status = "Enter a valid phone number";
			}
		}

		return status;
	}
}
