package com.example.ConsumerProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Autowired
    private RestConsumerConfiguration configuration;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .defaultHeaders(
                        httpHeaders -> httpHeaders.setBasicAuth(configuration.getUsername(),configuration.getPass()))
                .build();
    }
}
