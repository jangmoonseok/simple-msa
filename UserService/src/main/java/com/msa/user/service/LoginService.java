package com.msa.user.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msa.user.dao.MemberRepository;
import com.msa.user.entity.MemberEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService{

	private final MemberRepository repository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberEntity member = repository.findByMemberName(username)
										.orElseThrow(() -> new UsernameNotFoundException("유저가 존재하지 않습니다."));
		
		User.builder().username(member.getMemberName())
			.password(member.getPassword());
		return null;
	}

}
