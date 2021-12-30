package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableEurekaClient
@SpringBootApplication
@CrossOrigin(origins = "*")
public class ApigatewayService {
	public static void main(String[] args) {
		SpringApplication.run(ApigatewayService.class, args);
	}
	
	
	


}
