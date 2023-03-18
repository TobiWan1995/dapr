package com.example.vertragsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dapr")
public record DaprProperties(
        String stammdatenmethod_kunden,
        String stammdatenmethod_mitarbeiter,
        String projektmethod,
        String projektservice,
        String stammdatenservice) {
}
