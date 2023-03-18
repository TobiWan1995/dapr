package com.example.projektservice.dapr;

import com.example.projektservice.config.DaprProperties;
import com.example.projektservice.enitity.Projekt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.client.DaprClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherClient {

    private final DaprClient daprClient;
    private final DaprProperties daprProperties;

    public void publishProjektForSync(Projekt projekt) {
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.projekt_topic(), projekt).block();
    }
}
