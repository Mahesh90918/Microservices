package com.microServices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Both are Using WEBCLIENT synchronous and Asynchronous communication
	
	//RESTTEMPLATE using only synchronous
	
	// create a number of instance of Department application
	// MANAGING the load Balanced Instance
//	@Bean
//	@LoadBalanced
//	public RestTemplate rest() {
//		return new RestTemplate();
//	}
	
	@Bean
	@LoadBalanced
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
}
