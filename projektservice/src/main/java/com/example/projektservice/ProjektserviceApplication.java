package com.example.projektservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.projektservice.config")
public class ProjektserviceApplication {

	public static final Logger log = LoggerFactory.getLogger(ProjektserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjektserviceApplication.class, args);
	}

}
