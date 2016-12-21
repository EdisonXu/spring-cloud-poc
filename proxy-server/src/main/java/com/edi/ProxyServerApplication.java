package com.edi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ProxyServerApplication {

	public static void main(String[] args) {
        System.setProperty("spring.config.name", "proxy-server");
		new SpringApplicationBuilder(ProxyServerApplication.class)
                .web(true)
                //.bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
