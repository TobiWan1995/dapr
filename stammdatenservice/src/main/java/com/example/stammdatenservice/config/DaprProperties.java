package com.example.stammdatenservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dapr")
public record DaprProperties(
        String stammdatenmethod_kunden,
        String stammdatenmethod_mitarbeiter,
        String vertragmethod_kundenvertrag,
        String vertragmethod_partnervertrag,
        String projektmethod,
        String projektservice,
        String vertragservice,
        String stammdatenservice,
        String kunden_vertrag_topic,
        String kunden_projekt_topic,
        String mitarbeiter_vertrag_topic,
        String redis_broker,
        String redis_state_store) {
}
