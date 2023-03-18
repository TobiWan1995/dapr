package com.example.zeiterfassungservice.config;

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
        String mitarbeiter_monatsabschluss_topic,
        String redis_broker,
        String mongo_state_store) {
}
