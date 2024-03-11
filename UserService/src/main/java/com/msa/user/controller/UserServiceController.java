package com.msa.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserServiceController {

	@GetMapping("/main")
	public String main() {
		return "Hello UserService";
	}
}
