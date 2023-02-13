package com.sergio.bookstore.backend.user.config;

import com.sergio.bookstore.backend.user.dto.UserDto;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing authorization information");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

            System.out.println(authHeader);
            String[] parts = authHeader.split(" ");

            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new RuntimeException("Incorrect authorization structure");
            }

            return webClientBuilder.build()
                    .post()
                    .uri("http://auth-service/api/v1/validateToken")
                    .header(HttpHeaders.AUTHORIZATION, authHeader)
                    .retrieve().bodyToMono(UserDto.class)
                    .map(userDto -> {
                        exchange.getRequest()
                                .mutate()
                                .header("Authorization", String.valueOf(authHeader));
                        return exchange;
                    }).flatMap(chain::filter);
        };
    }

    public static class Config {
        // empty class as I don't need any particular configuration
    }
}
