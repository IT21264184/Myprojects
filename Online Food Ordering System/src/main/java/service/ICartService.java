package service;

import java.util.ArrayList;

import model.Cart;

public interface ICartService {

	public ArrayList<Cart> getItems(String email);
	
	public void clearAllItems(String email);
	
	public void clearSpecificItem(String email, int id);

	public void calculateSubTotal(ArrayList<Cart> itemList);
	
	public void changeQuantity(String email, int item_id, int quantity);
	
	public String addToCart(String email, int item_id, int quantity, String notes);
}
