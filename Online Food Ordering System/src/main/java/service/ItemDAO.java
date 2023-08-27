package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionProvider;
import util.DBConnectionUtil;
import model.Item;


public class ItemDAO {
	private static final String INSTERT_ITEMS_SQL ="INSERT INTO item VALUES(?,?,?,?,?);";
	private static final String SELECT_ITEMS_BY_ID ="select id, name,description, price, img FROM item where id =?";
	private static final String SELECT_ALL_ITEMS = "select * from item";
	private static final String DELETE_ITEMS_SQL = "DELETE from item where id = ?";
	private static final String UPDATE_ITEMS_SQL = "update item set name = ?,description=?, price = ? where id = ?";
	private PreparedStatement statement;

	
	public void insertItem(Item item) throws SQLException{	
		try (Connection connection = ConnectionProvider.getDBConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSTERT_ITEMS_SQL);){
			preparedStatement.setInt(1,  item.getItemID());
			preparedStatement.setString(2,  item.getItemName());
			preparedStatement.setString(3,  item.getItemDes());
			preparedStatement.setDouble(4,  item.getItemPrice());
			preparedStatement.setString(5,  item.getItemImg());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Item selectItem(int id) {
		Item item = null;
		
		try (Connection connection = ConnectionProvider.getDBConnection(); 
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEMS_BY_ID);){
			preparedStatement.setInt(1, item.getItemID());
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String image = rs.getString("img");
				
				item.setItemName(name);
				item.setItemDes(description);
				item.setItemPrice(price);
				item.setItemImg(image);
			}
			
		}catch (SQLException e) {
			printSQLException(e);
		}
		
		return item;	
	}
	
	public List < Item > selectAllItems(){
		List < Item > items = new ArrayList <> ();
		
		try(Connection connection = ConnectionProvider.getDBConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS);){
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Item item = new Item();
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String image = rs.getString("img");
				
				item.setItemName(name);
				item.setItemDes(description);
				item.setItemPrice(price);
				item.setItemImg(image);
				
				items.add(item);
			}
			
		}catch (SQLException e) {
			printSQLException(e);
		}
		
		return items;	
	}
	
	
	
	public boolean updateItem(Item item) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = ConnectionProvider.getDBConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ITEMS_SQL);){
			
			statement.setString(1, item.getItemName());
			statement.setDouble(3, item.getItemPrice());
			statement.setInt(4, item.getItemID());
			statement.setString(2, item.getItemDes());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	private void printSQLException(SQLException ex) {
		for(Throwable e: ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getSQLState());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				
				while(t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public ArrayList<Item> getAllItems() {
		Connection con = DBConnectionUtil.getDBConnection();
		
		ArrayList<Item> itemList = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery(SELECT_ALL_ITEMS);
			
			while (rs.next()) {
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
	
	public void addItems(int item_id, String desc, String name, double price, String img) {
		Connection con = DBConnectionUtil.getDBConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(INSTERT_ITEMS_SQL);
			
			pst.setInt(1, item_id);
			pst.setString(2, desc);
			pst.setString(3, name);
			pst.setDouble(4, price);
			pst.setString(5, img);
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void deleteItems(int item_id) {
        Connection con = DBConnectionUtil.getDBConnection();
        
        try {
            PreparedStatement pst = con.prepareStatement(DELETE_ITEMS_SQL);
            
            pst.setInt(1, item_id);
            
            pst.executeUpdate();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public void updateItems(int item_id, String desc, String name, double price, String img) {
        Connection con = DBConnectionUtil.getDBConnection();
        
        try {
            PreparedStatement pst = con.prepareStatement(UPDATE_ITEMS_SQL);
            
            pst.setInt(4, item_id);
            pst.setString(2, desc);
            pst.setString(1, name);
            pst.setDouble(3, price);
            
            pst.executeUpdate();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
			
		
	
