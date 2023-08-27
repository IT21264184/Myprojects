package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

	private int order_id;
	private ArrayList<Integer> item_id = new ArrayList<Integer>();
	private ArrayList<Integer> quantity = new ArrayList<Integer>();
	private ArrayList<String> item_name = new ArrayList<String>();
	private ArrayList<Double> item_price = new ArrayList<Double>();
	private ArrayList<String> img_path = new ArrayList<String>();
	private ArrayList<String> note = new ArrayList<String>();
	private LocalDate date;
	private String time;
	private String address;
	private String phone;
	private String cardNo;
	private String pay_type;
	private double order_total;
	

	public ArrayList<Integer> getItem_id() {
		return item_id;
	}

	public void setItem_id(ArrayList<Integer> item_id) {
		this.item_id = item_id;
	}

	public ArrayList<String> getItem_name() {
		return item_name;
	}

	public void setItem_name(ArrayList<String> item_name) {
		this.item_name = item_name;
	}

	public ArrayList<Double> getItem_price() {
		return item_price;
	}

	public void setItem_price(ArrayList<Double> item_price) {
		this.item_price = item_price;
	}

	public ArrayList<String> getImg_path() {
		return img_path;
	}

	public void setImg_path(ArrayList<String> img_path) {
		this.img_path = img_path;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String string) {
		this.time = string;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}

	public ArrayList<String> getNote() {
		return note;
	}

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(ArrayList<Integer> quantity) {
		this.quantity = quantity;
	}

}
