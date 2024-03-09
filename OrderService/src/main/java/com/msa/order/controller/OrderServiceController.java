package com.msa.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

	@GetMapping("/")
	public String main() {
		return "Hello OrderService";
	}
}
