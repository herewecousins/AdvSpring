package com.mysmartshop.authserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/msg")
	public String greet() {
		return "Hello from UST";
	}
	@GetMapping("/user")
	public String greet1() {
		return "Hello USER";
	}
	@GetMapping("/admin")
	public String greet2() {
		return "Hello ADMIN";
	}
}
