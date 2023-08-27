package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;
import util.DBConnectionUtil;

public class IndexServiceImpl implements IIndexService{
	private static Statement st;
	private static ResultSet rs;
	private static Connection con;
	
	@Override
	public ArrayList<Item> getItems() {
		// TODO Auto-generated method stub
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		con = DBConnectionUtil.getDBConnection();
		try {
		
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM item");
			
			while(rs.next()) {
				Item item = new Item(); 
				
				item.setItemID(rs.getInt(1));
                item.setItemDes(rs.getString(2));
                item.setItemName(rs.getString(3));
                item.setItemPrice(rs.getDouble(4));
                item.setItemImg(rs.getString(5));
                
                
                
                itemList.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemList;
	}
}
