package com.msa.user.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter{

	private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/api/user/login",
			"POST");
	
	private final ObjectMapper objectMapper;
	
	protected CustomLoginFilter(ObjectMapper objectMapper) {
		super(DEFAULT_ANT_PATH_REQUEST_MATCHER); // /api/user/login(POST) 요청과 매칭
		this.objectMapper = objectMapper;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userId, password);
		
		return this.getAuthenticationManager().authenticate(authToken);
	}

}
