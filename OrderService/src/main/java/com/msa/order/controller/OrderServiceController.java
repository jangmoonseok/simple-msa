package com.msa.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderServiceController {

	@GetMapping("/main")
	public String main() {
		return "Hello OrderService";
	}
}
