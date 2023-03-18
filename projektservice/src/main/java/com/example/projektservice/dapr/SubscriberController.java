package com.example.projektservice.dapr;

import com.example.projektservice.enitity.Kunde;
import com.example.projektservice.repository.KundenRepository;
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

    @Topic(name = "kunden-topic", pubsubName = "redis-pub-sub")
    @PostMapping(path = "/projekt/kunde/sync")
    public void syncKunde(@RequestBody(required = false) CloudEvent<Kunde> cloudEvent) {
        processCloudEvent(cloudEvent, ((x) -> kundenRepository.save((Kunde) x)));
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
