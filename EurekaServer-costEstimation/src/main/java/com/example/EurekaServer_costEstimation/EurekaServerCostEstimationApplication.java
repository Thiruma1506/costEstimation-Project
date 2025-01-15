package com.example.EurekaServer_costEstimation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerCostEstimationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerCostEstimationApplication.class, args);
	}

}
