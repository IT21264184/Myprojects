package service;

import java.util.ArrayList;

import model.Order;
import model.Rating;

public interface IRatingService {

	public void saveRating(String email,int order_id, int item_id, int rate_num, String review);
	
	public int[] checkRating(String email, ArrayList<Order> orderList);
	
	public ArrayList<Rating> getRatings(int item_id);
}
