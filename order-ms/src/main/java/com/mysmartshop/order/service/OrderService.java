package com.mysmartshop.order.service;

import java.util.List;

import com.mysmartshop.order.model.Cart;
import com.mysmartshop.order.model.Order;

public interface OrderService {
	
	public Order placeOrder (List<Cart> cartItems);
    public Order getOrderDetails(String orderId);
	public List<Order> getAllOrders();
	public void updateOrderDetails(String orderId, String status);
	public void cancelOrder(String orderId);

}
