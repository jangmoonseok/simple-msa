package com.msa.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.Config>{

	public CustomGatewayFilterFactory() {
		super(Config.class);
	}
	
	public static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			System.out.println("------------------GatewayFilter----------------------");
			return chain.filter(exchange); 
		};
	}

	
}

