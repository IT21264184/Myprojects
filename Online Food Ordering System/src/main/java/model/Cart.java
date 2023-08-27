package model;

public class Cart {

	private int item_id;
	private String item_name;
	private int quantity;
	private double item_price;
	private String img_path;
	private String notes;
	
	private static double sub_total;
	private static double tax;
	private static double total;

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public static double getTotal() {
		return total;
	}

	public static void setTotal(double total) {
		Cart.total = total;
	}

	public static double getSub_total() {
		return sub_total;
	}

	public static void setSub_total(double sub_total) {
		Cart.sub_total = sub_total;
	}

	public static double getTax() {
		return tax;
	}

	public static void setTax(double tax) {
		Cart.tax = tax;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
