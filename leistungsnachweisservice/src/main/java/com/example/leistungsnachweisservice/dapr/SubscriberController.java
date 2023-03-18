package com.example.leistungsnachweisservice.dapr;

import com.example.leistungsnachweisservice.api.model.MonatsabschlussCommand;
import com.example.leistungsnachweisservice.config.DaprProperties;
import com.example.leistungsnachweisservice.service.DienstleistungsnachweisService;
import io.dapr.Topic;
import io.dapr.client.DaprClient;
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

    private final DienstleistungsnachweisService dienstleistungsnachweisService;

    @Topic(name = "mitarbeiter-monatsabschluss-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/leistungsnachweis/monatsabschluss")
    public void createTaetigkeitenForLeistungsnachweisListener(@RequestBody(required = false) CloudEvent<MonatsabschlussCommand> cloudEvent) {
        processCloudEvent(cloudEvent, (x) -> dienstleistungsnachweisService.createDienstleistungsNachweiseForMonatsabschluss((MonatsabschlussCommand) x));
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
