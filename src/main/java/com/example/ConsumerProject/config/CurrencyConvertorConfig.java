package com.example.ConsumerProject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "currency")
@Data
public class CurrencyConvertorConfig {

    private String baseEndpoint;
}
