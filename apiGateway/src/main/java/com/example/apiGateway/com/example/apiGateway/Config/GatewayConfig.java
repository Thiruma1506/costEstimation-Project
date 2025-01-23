package com.example.apiGateway.com.example.apiGateway.Config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route("input-service", r -> r.path("/api/inputs/**")
                            .uri("http://localhost:8080"))
                    .route("cost-estimate-service", r -> r.path("/api/cost-estimates/**")
                            .uri("http://localhost:8081"))
                    .route("material-service", r -> r.path("/api/materials/**")
                            .uri("http://localhost:8083"))
                    .route("report-service", r -> r.path("/api/reports/**")
                            .uri("http://localhost:8084"))
                    .build();
        }
}
