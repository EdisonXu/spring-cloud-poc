package com.edi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		// tell boot to look for registration-server.yml
		System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
