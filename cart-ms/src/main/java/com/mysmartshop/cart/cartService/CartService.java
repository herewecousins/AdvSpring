package com.mysmartshop.cart.cartService;

import java.util.List;

import com.mysmartshop.cart.model.Cart;

public interface CartService {
	
	public List<Cart> addToCart(String productId);
	
	public List<Cart> removeFromCart(String productId);

	public List<Cart> updateQuantity(String productId, int quantity);

    public float calculateTotalCost();
    
    public List<Cart> getAllItems();

}
 