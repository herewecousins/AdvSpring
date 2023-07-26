package com.mysmartshop.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private String productId;
	private String name;
	private float price;
	private String description;
	

}
