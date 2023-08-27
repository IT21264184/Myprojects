package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Item;
import util.CommonConstants;
import util.DBConnectionUtil;

public class ItemServiceImpl implements IItemService{

	private static Connection con;

	private static Statement st;

	private static PreparedStatement pst;

	private static ResultSet rs;

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());
	
	@Override
	public Item getItem(int item_id) {
		// TODO Auto-generated method stub
		Item item = new Item();
		
		item.setItemID(item_id);
		
		con = DBConnectionUtil.getDBConnection();
		
		try {
			pst = con.prepareStatement(CommonConstants.QUERY_ID_GET_ITEM);
			
			pst.setInt(CommonConstants.COLUMN_INDEX_ONE, item_id);
			
			rs = pst.executeQuery();
			
			rs.next();
			
			item.setItemName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
			item.setItemImg(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
			item.setItemDes(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
			item.setItemPrice(rs.getDouble(CommonConstants.COLUMN_INDEX_THREE));
			
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
		
		
		
		return item;
	}

}
