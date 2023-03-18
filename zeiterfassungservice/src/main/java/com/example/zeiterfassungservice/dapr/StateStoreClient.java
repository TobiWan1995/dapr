package com.example.zeiterfassungservice.dapr;

import com.example.zeiterfassungservice.config.DaprProperties;
import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;
import io.dapr.client.DaprClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StateStoreClient {

    private final DaprClient daprClient;

    private final DaprProperties daprProperties;

    public MitarbeiterMonat getMitarbeiterMonatFromStore(String key) {
        return Optional.ofNullable(daprClient.getState(daprProperties.mongo_state_store(), key, MitarbeiterMonat.class)
                .block()).orElseThrow().getValue();
    }

    public void saveUncommitedMitarbeiterMonatInStore(MitarbeiterMonat mitarbeiterMonat) {
        String key = mitarbeiterMonat.getMonat().toString() + mitarbeiterMonat.getMitarbeiter().toString();
        daprClient.saveState(daprProperties.mongo_state_store(), key, mitarbeiterMonat).block();
    }

    public Void removeMitarbeiterMonatFromStore(String key) {
        return daprClient.deleteState(daprProperties.mongo_state_store(), key).block();
    }
}
