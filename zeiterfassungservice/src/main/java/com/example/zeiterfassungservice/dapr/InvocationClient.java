package com.example.zeiterfassungservice.dapr;

import com.example.zeiterfassungservice.api.model.KundenvertragAufstellung;
import com.example.zeiterfassungservice.api.model.MitarbeiterDto;
import com.example.zeiterfassungservice.api.model.PartnervertragDto;
import com.example.zeiterfassungservice.api.model.ProjektDto;
import com.example.zeiterfassungservice.config.DaprProperties;
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

    public List<MitarbeiterDto> invokeStammdatenServiceForMitarbeiter(List<Long> mitarbeiterIds) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.stammdatenservice(),
                daprProperties.stammdatenmethod_mitarbeiter() + "/mitarbeiter",
                mitarbeiterIds, HttpExtension.POST, MitarbeiterDto[].class).block()).orElseThrow());
    }

    public KundenvertragAufstellung invokeVertragServiceForKundenvertragAufstellungForProjekt(Long projektId) {
        return Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_kundenvertrag() + "/projekt/" + projektId,
                new HttpHeaders(), HttpExtension.GET, KundenvertragAufstellung.class).block()).orElseThrow();
    }

    public List<PartnervertragDto> invokeVertragServiceForPartnervertraegeForMitarbeiter(Long mitarbeiterId) {
        return List.of(Optional.ofNullable(daprClient.invokeMethod(daprProperties.vertragservice(),
                daprProperties.vertragmethod_partnervertrag() + "/mitarbeiter/" + mitarbeiterId,
                new HttpHeaders(), HttpExtension.GET, PartnervertragDto[].class).block()).orElseThrow());
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
