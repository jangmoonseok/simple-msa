package com.msa.user.filter;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter{

	private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/api/user/login",
			"POST");
	
	
	public CustomLoginFilter(AuthenticationManager authenticationManager, AuthenticationSuccessHandler successHandler) {
		super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager); // /api/user/login(POST) 요청과 매칭
		setAuthenticationSuccessHandler(successHandler);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		 String method = request.getMethod();

        if (!method.equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        ServletInputStream inputStream = request.getInputStream();
        
        HashMap<String,String> readValue = new ObjectMapper().readValue(inputStream, HashMap.class);
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
															readValue.get("userId"), readValue.get("password")
														);
		
		return this.getAuthenticationManager().authenticate(authToken);
	}

}
