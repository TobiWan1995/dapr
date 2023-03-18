package com.example.vertragsservice.dapr;

import com.example.vertragsservice.api.model.ProjektDto;
import com.example.vertragsservice.config.DaprProperties;
import com.example.vertragsservice.enitity.Kunde;
import com.example.vertragsservice.enitity.Mitarbeiter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InvocationClient {

    private final DaprClient daprClient;
    private final DaprProperties daprProperties;

    public List<Mitarbeiter> invokeStammdatenServiceForMitarbeiter(List<Long> mitarbeiterIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.stammdatenservice(), daprProperties.stammdatenmethod_mitarbeiter() + "/mitarbeiter",
                       mitarbeiterIds, HttpExtension.POST, Mitarbeiter[].class).block()).orElseThrow());
    }

    public List<Kunde> invokeStammdatenServiceForKunden(List<Long> kundenIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.stammdatenservice(),daprProperties.stammdatenmethod_kunden() + "/kunden",
                kundenIds, HttpExtension.POST, Kunde[].class).block()).orElseThrow());
    }

    public ProjektDto invokeProjektServiceForProjekt(Long projektId) {
        return Optional.ofNullable(daprClient
                .invokeMethod(daprProperties.projektservice(), daprProperties.projektmethod() + "/" + projektId,
                        new HttpHeaders(), HttpExtension.GET, ProjektDto.class).block()).orElseThrow();
    }

    private byte[] writeValuesAsBytes(Object o) {
        try {
            return new ObjectMapper().writeValueAsBytes(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
