package com.asheef.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.WebFilter;

@Configuration
public class CrossGlobalConfiguration {

    @Bean
    public WebFilter corsFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = exchange.getResponse();
                HttpHeaders headers = response.getHeaders();

                headers.set("Access-Control-Allow-Origin", "http://localhost:5173");
                headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
                headers.set("Access-Control-Allow-Headers", "Content-Type, Authorization");
                headers.set("Access-Control-Allow-Credentials", "true");

                // ✅ Correct method call here
                if ("OPTIONS".equals(request.getMethod().name())) {
                    response.setStatusCode(org.springframework.http.HttpStatus.OK);
                    return response.setComplete();
                }
            }
            return chain.filter(exchange);
        };
    }
}
