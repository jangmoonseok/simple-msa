package com.msa.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

	@GetMapping("/")
	public String main() {
		return "Hello UserService";
	}
}
