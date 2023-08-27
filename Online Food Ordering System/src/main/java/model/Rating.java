package model;

public class Rating {

	private int rate_id;
	private String review;
	private int rate_num;
	private int order_id;
	private int item_id;
	private String email;
	private String name;

	public int getRate_id() {
		return rate_id;
	}

	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRate_num() {
		return rate_num;
	}

	public void setRate_num(int rate_num) {
		this.rate_num = rate_num;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
