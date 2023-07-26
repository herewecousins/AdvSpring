package com.mysmartshop.cart.dto;

import java.util.List;

import com.mysmartshop.cart.model.Cart;

import lombok.Data;

@Data
	public class CartDetails {

		private List<Cart> itemsList;
		private float totalCartValue;
		
	}

