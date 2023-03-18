package com.example.stammdatenservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.stammdatenservice.config")
public class StammdatenserviceApplication {

	public static final Logger log = LoggerFactory.getLogger(StammdatenserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StammdatenserviceApplication.class, args);
	}

}
