package com.example.vertragsservice.dapr;

import com.example.vertragsservice.enitity.Kunde;
import com.example.vertragsservice.enitity.Mitarbeiter;
import com.example.vertragsservice.repository.KundenRepository;
import com.example.vertragsservice.repository.MitarbeiterRepository;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RestController
@RequiredArgsConstructor
public class SubscriberController {

    private final KundenRepository kundenRepository;

    private final MitarbeiterRepository mitarbeiterRepository;

    @Topic(name = "kunden-vertrag-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/vertrag/kunde/sync")
    public void syncKunde(@RequestBody(required = false) CloudEvent<Kunde> cloudEvent) {
        processCloudEvent(cloudEvent, ((x) -> kundenRepository.save((Kunde) x)));
    }

    @Topic(name = "mitarbeiter-vertrag-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/vertrag/mitarbeiter/sync")
    public void syncMitarbeiter(@RequestBody(required = false) CloudEvent<Mitarbeiter> cloudEvent) {
        processCloudEvent(cloudEvent, ((x) -> mitarbeiterRepository.save((Mitarbeiter) x)));
    }

    private <T> void processCloudEvent(CloudEvent<T> cloudEvent, Function<Object, Object> callbackFunction) {
        Mono.fromRunnable(() -> {
            try {
                callbackFunction.apply(cloudEvent.getData());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).block();
    }
}
