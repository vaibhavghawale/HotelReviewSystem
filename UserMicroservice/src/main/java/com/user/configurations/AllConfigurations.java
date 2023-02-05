package com.user.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AllConfigurations {

	@Bean
	@LoadBalanced // to use for balancing a load and help to call with name not with port 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
