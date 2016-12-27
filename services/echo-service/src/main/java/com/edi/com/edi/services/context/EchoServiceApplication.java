package com.edi.com.edi.services.context;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.edi.services.web"})
public class EchoServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "echo-service");
		new SpringApplicationBuilder(EchoServiceApplication.class).web(true).run(args);
	}
}
