package com.example.userLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

// .requestMatchers("/api/users/register").permitAll()
// .requestMatchers("/api/inputs/**").hasRole("USER")
// .requestMatchers("/api/admin/**").hasRole("ADMIN")