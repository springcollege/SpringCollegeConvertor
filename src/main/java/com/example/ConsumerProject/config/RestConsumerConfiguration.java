package com.example.ConsumerProject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "rest")
@Data
public class RestConsumerConfiguration {

    private String baseUrl;
    private String getInquiriesByStatusUrl;
    private String saveInquiryUrl;
    private String deleteInquiryUrl;
    private String username;
    private String pass;
}
