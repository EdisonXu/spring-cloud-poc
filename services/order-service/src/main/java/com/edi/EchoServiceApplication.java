package com.edi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EchoServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "echo-service");
		new SpringApplicationBuilder(EchoServiceApplication.class).web(true).run(args);
	}
}
