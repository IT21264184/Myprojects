package util;

public class CommonConstants {

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for query tag in EmployeeQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in EmployeeQuery.xml */
	public static final String ATTRIB_ID = "id";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for enc/decp key */
	public static final int KEY = 15;
	
	/** Constant for tax rate */
	public static final double TAX_RATE = 0.1;
	
	/** Constant for delivery fee */
	public static final double DELIVERY_FEE = 200;

	/** Constant for query id of get all items for the cart in Query.xml */
	public static final String QUERY_ID_ALL_CART = "select * from Cart_Item ci, Cart c, Customer cu where c.customer = cu.email and ci.cid = c.id and c.customer = ?;";

	/**
	 * Constant for query id of delete a particular customers whole cart by email
	 * Query in Query.xml
	 */
	public static final String QUERY_ID_CLEAR_CART = "DELETE FROM cart_item WHERE cid = (select id from Cart where customer = ?);";

	/**
	 * Constant for query id of delete specific items from the cart Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_CLEAR_SPECIFIC_CART = "DELETE FROM cart_item WHERE cid = (select id from Cart where customer = ?) and it_id = ?;";

	/**
	 * Constant for query id of changing quantity of a item
	 * Query in Query.xml
	 */
	public static final String QUERY_ID_CHANGE_QUANTITY = "UPDATE cart_item SET quantity = ? WHERE it_id = ? and cid = (select id from cart where customer = ?);";
	
	/**
	 * Constant for query id of add item to cart
	 * Query.xml
	 */
	public static final String QUERY_ID_ADD_TO_CART = "INSERT INTO cart_item (cid, it_id, quantity, notes) VALUES((select id from cart where customer=?), ?, ?, ?);";
	
	
	/**
	 * Constant for query id of select a particular customer by email Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_GET_CUSTOMER = "select * from Customer where email = ?";

	/**
	 * Constant for query id of delete a particular customer by email Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_DELETE_CUSTOMER = "delete from Customer where email = ?";

	/**
	 * Constant for query id of update a particular customers email by email Query
	 * in Query.xml
	 */
	public static final String QUERY_ID_UPDATE_CUSTOMER_EMAIL = "UPDATE customer SET email = ? WHERE email = ?;";

	/**
	 * Constant for query id of update a particular customers address by email Query
	 * in Query.xml
	 */
	public static final String QUERY_ID_UPDATE_CUSTOMER_ADDRESS = "UPDATE customer SET address = ? WHERE email = ?;";

	/**
	 * Constant for query id of update a particular customers name by email Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_UPDATE_CUSTOMER_NAME = "UPDATE customer SET name = ? WHERE email = ?;";

	/**
	 * Constant for query id of update a particular customers phone by email Query
	 * in Query.xml
	 */
	public static final String QUERY_ID_UPDATE_CUSTOMER_PHONE = "UPDATE customer SET phone = ? WHERE email = ?;";

	/**
	 * Constant for query id of Get price, img path, name for a item from the cart Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_GET_PRICE_IMG_NAME = "select price, img, name from item where id = ?;";

	/**
	 * Constant for query id of add favourite cart Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_ADD_FAVOURITE = "INSERT INTO favourite (customer, it_id) VALUES (?, ?);";
	
	/**
	 * Constant for query id of get favourite Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_GET_FAVOURITES = "SELECT * FROM favourite where customer=?;";
	
	/**
	 * Constant for query id of remove favourite Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_REMOVE_FAVOURITE = "DELETE FROM favourite WHERE customer = ? and it_id = ?;";
	
	/**
	 * Constant for query id of get item description Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_GET_ITEM_DESCRIPTION = "select description from item where id = ?;";
	
	/**
	 * Constant for query id of insert payment Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_ADD_PAYMENT = "INSERT INTO payment(type,cardNo,ccv,expDate,name) VALUES(?,?,?,?,?);";
	
	/**
	 * Constant for query id of insert details to item_order Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_ADD_TO_ITEM_ORDER = "INSERT INTO item_order (it_id, oid, qty, note) VALUES(?, ?, ?, (select notes from cart_item where cid = (select id from Cart where customer = ?) and it_id = ?));";

	/**
	 * Constant for query id of create order Query in
	 * Query.xml
	 */
	public static final String QUERY_ID_CREATE_ORDER = "INSERT INTO order_(date, total, time, address, phone) VALUES(?, ?, ?, ?, ?);";
	
	/** remove cache from mysql*/
	public static final String QUERY_ID_REMOVE_CACHE = "SET @@SESSION.information_schema_stats_expiry = 0;";
	
	/** last id in orders_ */
	public static final String QUERY_ID_ORDER_ID = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'oop_project' AND TABLE_NAME = 'order_';";
	
	/** last id in orders_ */
	public static final String QUERY_ID_PAYMENT_ID = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'oop_project' AND TABLE_NAME = 'payment';";
	
	/** add data to place table*/
	public static final String QUERY_ID_ADD_TO_PLACE = "INSERT INTO place(email, pid, oid) VALUES(?, ?, ?);";
	
	/** get order details from email*/
	public static final String QUERY_ID_GET_ORDERS = "select * from order_ where id in (select oid from place where email=?);";
	
	/** get item details from oid*/
	public static final String QUERY_ID_GET_ITEMS = "select it_id, note, qty from item_order where oid=?";
	
	/** get payment details for a specific order id*/
	public static final String QUERY_ID_GET_PAYMENT_FOR_OID = "select type, cardNo from payment p, place pl where p.id=pl.pid and oid =?";
		
	/** add data to rate table*/
	public static final String QUERY_ID_ADD_TO_RATE = "INSERT INTO rating(email, oid, it_id, rate_num, review) VALUES(?, ?, ?, ?, ?);";
	
	/** check if already rated*/
	public static final String QUERY_ID_CHECK_RATE = "select * from rating where email=? and oid=? and it_id=?;";
	
	/** get ratings for an item*/
	public static final String QUERY_ID_GET_RATING = "select email, review, rate_num from rating where it_id=?;";
	
	/** get everything from item table from item id*/
	public static final String QUERY_ID_GET_ITEM = "select description, name, price, img from item where id = ?;";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;

	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;

	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;

	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;

	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;

	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;

	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;

	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
}
