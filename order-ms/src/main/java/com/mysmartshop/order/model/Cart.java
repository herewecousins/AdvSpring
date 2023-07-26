package com.mysmartshop.order.model;

import lombok.Data;


@Data
public class Cart {
	
	private int cartId;
    private String productId;
    private int quantity;
    private float totalPrice;

}

