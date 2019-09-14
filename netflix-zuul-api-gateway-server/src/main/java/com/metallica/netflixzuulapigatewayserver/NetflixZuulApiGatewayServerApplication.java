package com.metallica.netflixzuulapigatewayserver;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableResourceServer
public class NetflixZuulApiGatewayServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}

}
