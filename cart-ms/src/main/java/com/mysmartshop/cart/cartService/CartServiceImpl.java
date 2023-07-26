package com.mysmartshop.cart.cartService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mysmartshop.cart.dto.Product;
import com.mysmartshop.cart.model.Cart;
import com.mysmartshop.cart.repo.CartRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo itemRepository;
	
	@Autowired
	RestTemplate productServiceClient;

	@Override
	public List<Cart> addToCart(String productId) {
		
		Optional<Cart> checkItem = itemRepository.findByProductId(productId);
		
		if(!checkItem.isPresent()) {
			Cart item = new Cart();
			item.setProductId(productId);
			item.setQuantity(1);
			item.setTotalPrice(fetchPrice(productId));
			itemRepository.save(item);
		}
		else {
			Cart item = checkItem.get();
			updateQuantity(productId, item.getQuantity()+1);
		}
		
		return getAllItems();
	}

	@Override
	public List<Cart> removeFromCart(String productId) {
		
		Optional<Cart> checkItem = itemRepository.findByProductId(productId);
		if(checkItem.isPresent()) {
			Cart item = checkItem.get();
			itemRepository.delete(item);
		}
		
		
		return getAllItems();
	}

	@Override
	public List<Cart> updateQuantity(String productId, int quantity) {
		
		Optional<Cart> checkItem = itemRepository.findByProductId(productId);
		
		if(checkItem.isPresent()) {
			Cart item = checkItem.get();
			float unitPrice = item.getTotalPrice()/item.getQuantity();
			item.setQuantity(quantity);
			item.setTotalPrice(item.getTotalPrice()*quantity);
			item.setTotalPrice(unitPrice*quantity);
			itemRepository.save(item);
		}

		
		return itemRepository.findAll();
		
	}

	@Override
	public float calculateTotalCost() {
		return itemRepository.getTotalCartValue();
		
	}
	
	public List<Cart> getAllItems(){
		return itemRepository.findAll();
	}
	
	@CircuitBreaker(fallbackMethod = "fetchPriceFallback",name="cb-product")
	private float fetchPrice(String productId) {
		
		Product product = productServiceClient.getForObject("http://localhost:8100/api/product/"+productId, Product.class);
		if(product != null)
			return product.getPrice();
		return 0;
	}

	private float fetchPriceFallback(String productId, Throwable t) {
		Product product = new Product(productId,"Dummy product",0,"A Dummy product ");
		System.err.println(t.getMessage());
		System.out.println("Response from fallback");
		System.out.println(product);
		return product.getPrice();
	}

}
