package com.example.zeiterfassungservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.zeiterfassungservice.config")
public class ZeiterfassungserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeiterfassungserviceApplication.class, args);
	}

}
