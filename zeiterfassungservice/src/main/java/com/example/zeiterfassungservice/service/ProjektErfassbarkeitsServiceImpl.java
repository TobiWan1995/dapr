package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.api.model.KundenvertragAufstellung;
import com.example.zeiterfassungservice.api.model.PartnervertragDto;
import com.example.zeiterfassungservice.api.model.ProjektErfassbarkeitsAufstellung;
import com.example.zeiterfassungservice.dapr.InvocationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("projekterfassbarkeitsService")
@RequiredArgsConstructor
public class ProjektErfassbarkeitsServiceImpl implements ProjektErfassbarkeitsService {

    private final InvocationClient invocationClient;

    @Override
    public ProjektErfassbarkeitsAufstellung retrieveProjektErfassbarkeitsAufstellungForMitarbeiter(Long id) {
        // retrieve Pvs for Mitarbeiter with Service Invocation Component
        List<PartnervertragDto> pvsForMitarbeier = invocationClient.invokeVertragServiceForPartnervertraegeForMitarbeiter(id);

        // retrieve Kundenvertragsaufstellungen for each Projekt from Pvs
        List<KundenvertragAufstellung> kundenvertragAufstellungen = pvsForMitarbeier.stream()
                .map(PartnervertragDto::getProjekt)
                .map(invocationClient::invokeVertragServiceForKundenvertragAufstellungForProjekt)
                .toList();

        return new ProjektErfassbarkeitsAufstellung(kundenvertragAufstellungen, pvsForMitarbeier);
    }

}
