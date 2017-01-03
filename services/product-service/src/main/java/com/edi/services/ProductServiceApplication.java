package com.edi.services;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.edi"})
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "product-service");
		new SpringApplicationBuilder(ProductServiceApplication.class).web(true).run(args);
	}
}
