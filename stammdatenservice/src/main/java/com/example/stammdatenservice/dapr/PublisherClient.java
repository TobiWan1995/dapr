package com.example.stammdatenservice.dapr;

import com.example.stammdatenservice.config.DaprProperties;
import com.example.stammdatenservice.entity.Kunde;
import com.example.stammdatenservice.entity.Mitarbeiter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.client.DaprClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherClient {

    private final DaprClient daprClient;
    private final DaprProperties daprProperties;

    /**
     * publish Kunden after Change for Vertrag-Service and Projekt-Service
     **/
    public void publishKundeForSync(Kunde kunde) {
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.kunden_vertrag_topic(), kunde).block();
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.kunden_projekt_topic(), kunde).block();
    }

    /**
     * publish Mitarbeiter after Change for Vertrag-Service
     **/
    public void publishMitarbeiterForSync(Mitarbeiter mitarbeiter) {
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.mitarbeiter_vertrag_topic(), mitarbeiter).block();
    }

    public String writeValueAsString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
