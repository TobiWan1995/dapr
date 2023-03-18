package com.example.zeiterfassungservice.dapr;

import com.example.zeiterfassungservice.service.MitarbeiterMonatService;
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

    private final StateStoreClient stateStoreClient;
    private final MitarbeiterMonatService mitarbeiterMonatService;


    @Topic(name = "monatsabschluss-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/monatsabschluss/rollback")
    public void rollbackMonatsAbschlussListener(@RequestBody(required = false) CloudEvent<String> cloudEvent) {
        // remove failed Monatsabschluss from State Store
        processCloudEvent(cloudEvent, (x) -> stateStoreClient.removeMitarbeiterMonatFromStore(cloudEvent.getData()));
        // send message to user for action required...
    }

    @Topic(name = "monatsabschluss-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/monatsabschluss/commit")
    public void commmitMonatsAbschlussListener(@RequestBody(required = false) CloudEvent<String> cloudEvent) {
        processCloudEvent(cloudEvent, ((x) -> {
            // save committed MonatsAbschluss from State Store to Database
            mitarbeiterMonatService.saveMitarbeiterMonat(stateStoreClient.getMitarbeiterMonatFromStore(cloudEvent.getData()));
            // remove committed MonatsAbschluss from State Store
            return stateStoreClient.removeMitarbeiterMonatFromStore(cloudEvent.getData());
        }));
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
