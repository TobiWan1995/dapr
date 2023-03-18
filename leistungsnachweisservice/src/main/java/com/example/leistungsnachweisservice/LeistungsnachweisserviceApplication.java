package com.example.leistungsnachweisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.leistungsnachweisservice.config")
public class LeistungsnachweisserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeistungsnachweisserviceApplication.class, args);
	}

}
