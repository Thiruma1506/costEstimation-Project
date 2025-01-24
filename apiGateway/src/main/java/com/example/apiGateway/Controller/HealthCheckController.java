package com.example.apiGateway.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class HealthCheckController {

        @GetMapping("/health")
        public String healthCheck() {
            return "API Gateway is up and running";
        }
    }

