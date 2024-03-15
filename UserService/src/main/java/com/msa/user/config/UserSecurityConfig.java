package com.msa.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.requestMatchers("/api/user/login").permitAll() // 로그인 요청에 대한 모든 권한 허용
//			.and()
//			.authorizeRequests().anyRequest().authenticated() // 그외 모든 요청은 인증 필요
//			.and()
//			.formLogin().disable()
//			.httpBasic().disable()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		
//		return http.build();
//	}
}
