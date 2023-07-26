package com.mysmartshop.cart.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;




@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int cartId;
    private String productId;
    private int quantity;
    private float totalPrice;

}

