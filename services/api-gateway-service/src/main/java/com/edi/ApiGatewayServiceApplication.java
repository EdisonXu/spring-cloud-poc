package com.edi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "api-gateway");
		new SpringApplicationBuilder(ApiGatewayServiceApplication.class).web(true).run(args);
	}
}
