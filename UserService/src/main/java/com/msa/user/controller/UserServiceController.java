package com.msa.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.user.entity.MemberEntity;
import com.msa.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserServiceController {

	private final UserService service;
	
	@GetMapping("/main")
	public String main() {
		return "Hello UserService";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody MemberEntity member){
		MemberEntity signUp = service.signUp(member);
		return new ResponseEntity<>(signUp.getMemberName(), HttpStatus.OK);
	}
}
