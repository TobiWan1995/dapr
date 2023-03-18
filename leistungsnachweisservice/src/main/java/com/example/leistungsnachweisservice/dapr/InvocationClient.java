package com.example.leistungsnachweisservice.dapr;

import com.example.leistungsnachweisservice.api.model.KundenvertragDto;
import com.example.leistungsnachweisservice.api.model.MitarbeiterDto;
import com.example.leistungsnachweisservice.api.model.PartnervertragDto;
import com.example.leistungsnachweisservice.api.model.ProjektDto;
import com.example.leistungsnachweisservice.config.DaprProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InvocationClient {

    private final DaprClient daprClient;
    private final DaprProperties daprProperties;

    public List<MitarbeiterDto> invokeStammdatenServiceForMitarbeiter(List<Long> mitarbeiterIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.stammdatenservice(),
                daprProperties.stammdatenmethod_mitarbeiter() + "/mitarbeiter",
                mitarbeiterIds, HttpExtension.POST, MitarbeiterDto[].class).block()).orElseThrow());
    }

    public List<PartnervertragDto> invokeVertragServiceForPartnervertraege(List<Long> pvIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_partnervertrag() + "/partnervertraege",
                pvIds, HttpExtension.POST, PartnervertragDto[].class).block()).orElseThrow());
    }

    public List<KundenvertragDto> invokeVertragServiceForKundenvertraege(List<Long> kvIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_kundenvertrag() + "/kundenvertraege",
                kvIds, HttpExtension.POST, KundenvertragDto[].class).block()).orElseThrow());
    }

    public KundenvertragDto invokeVertragServiceForKundenvertrag(Long kvId) {
        return Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_kundenvertrag() + "/" + kvId,
                null, HttpExtension.GET, KundenvertragDto.class).block()).orElseThrow();
    }

    public PartnervertragDto invokeVertragServiceForPartnervertrag(Long pvId) {
        return Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_partnervertrag() + "/" + pvId,
                null, HttpExtension.GET, PartnervertragDto.class).block()).orElseThrow();
    }

    public ProjektDto invokeProjektServiceForProjekte(List<Long> projektIds) {
        return Optional.ofNullable(daprClient
                .invokeMethod(daprProperties.projektservice(), daprProperties.projektmethod() + "/projekte",
                        projektIds, HttpExtension.POST, ProjektDto.class).block()).orElseThrow();
    }

    private byte[] writeValuesAsBytes(Object o) {
        try {
            return new ObjectMapper().writeValueAsBytes(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
