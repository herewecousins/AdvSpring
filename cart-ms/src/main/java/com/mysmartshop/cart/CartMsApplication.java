package com.mysmartshop.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//@SpringBootApplication

@SpringBootApplication
@EnableDiscoveryClient
public class CartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartMsApplication.class, args);
	}

}
