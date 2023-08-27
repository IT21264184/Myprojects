package service;

import java.util.ArrayList;

import model.Order;

public interface IOrderService {
	
	public void createOrder(String email, String address, String phone);
	
	public ArrayList<Order> getOrder(String email);
}
