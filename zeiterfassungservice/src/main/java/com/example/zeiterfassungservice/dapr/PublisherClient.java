package com.example.zeiterfassungservice.dapr;

import com.example.zeiterfassungservice.api.model.MonatsabschlussCommand;
import com.example.zeiterfassungservice.config.DaprProperties;
import io.dapr.client.DaprClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherClient {

    private final DaprClient daprClient;

    private final DaprProperties daprProperties;

    /**
     * if published successfully taetigkeiten will reach leistungsnachweis-service, even if currently
     * not available because of messagequeue from broker -> will process messages if available again
     **/
    public void publishTaetigkeitenForMitarbeiterMonatsAbschluss(MonatsabschlussCommand monatsabschlussCommand) {
        daprClient.publishEvent(daprProperties.redis_broker(), daprProperties.mitarbeiter_monatsabschluss_topic(),
                monatsabschlussCommand).block();
    }
}
