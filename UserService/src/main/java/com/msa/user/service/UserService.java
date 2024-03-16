package com.msa.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.msa.user.dao.MemberRepository;
import com.msa.user.entity.MemberEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final MemberRepository repository;
	private final BCryptPasswordEncoder encoder;
	
	public MemberEntity signUp(MemberEntity member) {
		member.passwordEncoder(encoder);
		return repository.save(member);
	}
}
