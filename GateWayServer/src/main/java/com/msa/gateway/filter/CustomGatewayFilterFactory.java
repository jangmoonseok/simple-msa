package com.msa.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.msa.gateway.exception.UnAuthorizationException;

import reactor.core.publisher.Mono;

@Component
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.Config>{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public CustomGatewayFilterFactory() {
		super(Config.class);
	}
	
	public static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			logger.info("{} apply start", this.getClass().getName());
			String token = exchange.getRequest().getHeaders().get("Authorization").get(0);
			if(token == null) {
				throw new UnAuthorizationException("인증실패");
			}
			return chain.filter(exchange); 
		};
	}
}

