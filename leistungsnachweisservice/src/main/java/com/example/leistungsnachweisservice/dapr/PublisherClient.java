package com.example.leistungsnachweisservice.dapr;

import com.example.leistungsnachweisservice.config.DaprProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.client.DaprClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class PublisherClient {

    private final DaprClient daprClient;
    private final DaprProperties daprProperties;


    public Void publishMonatsabschlussCommit(Long mitarbeiterId, LocalDate zeitraum) {
        return daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.monatsabschluss_topic_commit(),
                zeitraum.toString() + mitarbeiterId.toString()).block();
    }

    public void publishMonatsabschlussRollback(Long mitarbeiterId, LocalDate zeitraum) {
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.monatsabschluss_topic_rollback(),
                zeitraum.toString() + mitarbeiterId.toString()).block();
    }

    public String writeValueAsString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
