package com.example.ConsumerProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableFeignClients(basePackages = "com.example.ConsumerProject.clients")
public class ConsumerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerProjectApplication.class, args);
	}

}
