package com.example.vertragsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.vertragsservice.config")
public class VertragsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VertragsserviceApplication.class, args);
	}

}
