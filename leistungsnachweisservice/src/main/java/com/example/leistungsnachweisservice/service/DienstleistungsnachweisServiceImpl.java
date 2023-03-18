package com.example.leistungsnachweisservice.service;

import com.example.leistungsnachweisservice.api.mapper.DienstleistungsnachweisMapper;
import com.example.leistungsnachweisservice.api.model.*;
import com.example.leistungsnachweisservice.dapr.InvocationClient;
import com.example.leistungsnachweisservice.dapr.PublisherClient;
import com.example.leistungsnachweisservice.enitity.Dienstleistungsnachweis;
import com.example.leistungsnachweisservice.repository.DienstleistungsnachweisRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("dienstleistungsnachweisservice")
@RequiredArgsConstructor
public class DienstleistungsnachweisServiceImpl implements DienstleistungsnachweisService {

    private final DienstleistungsnachweisRepository dienstleistungsnachweisRepository;

    private final DienstleistungsnachweisMapper dienstleistungsnachweisMapper;

    private final InvocationClient invocationClient;
    private final PublisherClient publisherClient;

    @Transactional
    public Void createDienstleistungsNachweiseForMonatsabschluss(MonatsabschlussCommand cmd) {
        try {
            // build Dienstleistungsnachweise from Taetigkeiten and save
            dienstleistungsnachweisRepository.saveAll(cmd.getTaetigkeiten()
                    .stream().map(this::buildDienstleistungsnachweisFromTaetigkeit).toList());

            // commit transaction to zeiterfassung-service if successful
            return publisherClient.publishMonatsabschlussCommit(
                    cmd.getMitarbeiterMonat().getMitarbeiter(),
                    cmd.getMitarbeiterMonat().getMonat());

        } catch (Exception e) {
            // rollback and revert Monatsabschluss from Mitarbeiter
            publisherClient.publishMonatsabschlussRollback(
                    cmd.getMitarbeiterMonat().getMitarbeiter(),
                    cmd.getMitarbeiterMonat().getMonat());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<DienstleistungsnachweisDto> retrieveAllDienstleistungsnachweise() {
        List<Dienstleistungsnachweis> dlns = dienstleistungsnachweisRepository.findAll();

        // retrieve Kundenvertraege via Service Invocation
        List<Long> kvIds = dlns.stream().map(Dienstleistungsnachweis::getKundenvertrag).toList();
        List<KundenvertragDto> kvs = invocationClient.invokeVertragServiceForKundenvertraege(kvIds);

        // retrieve Partnervertraege via Service Invocation
        List<Long> pvIds = dlns.stream().map((Dienstleistungsnachweis::getPartnervertrag)).toList();
        List<PartnervertragDto> pvs = invocationClient.invokeVertragServiceForPartnervertraege(pvIds);

        return joinVertraegeMitDienstleistungsnachweis(dlns, pvs, kvs).stream().map(entry -> dienstleistungsnachweisMapper
                .toDto(entry.getKey(), entry.getValue().getKey(), entry.getValue().getValue())).toList();
    }

    @Override
    public DienstleistungsnachweisDto updateDienstleistungsnachweis(Dienstleistungsnachweis dienstleistungsnachweis) {
        if(dienstleistungsnachweisRepository.findById(dienstleistungsnachweis.getId()).isEmpty())
            dienstleistungsnachweisNotExistingForId(dienstleistungsnachweis.getId());

        // retrieve Kundenvertrag via Service Invocation
        KundenvertragDto kv = invocationClient.invokeVertragServiceForKundenvertrag(dienstleistungsnachweis.getKundenvertrag());

        // retrieve Partnervertrag via Service Invocation
        PartnervertragDto pv = invocationClient.invokeVertragServiceForPartnervertrag(dienstleistungsnachweis.getPartnervertrag());

        return dienstleistungsnachweisMapper.toDto(dienstleistungsnachweisRepository.save(dienstleistungsnachweis), pv, kv);
    }

    private Dienstleistungsnachweis buildDienstleistungsnachweisFromTaetigkeit(TaetigkeitDto t) {
        // Berechnen der Personentage auf 8-Stunden-Basis
        long stunden = Duration.between(t.getBeginn(), t.getEnde()).minusSeconds(t.getPause()).toHours();
        BigDecimal personentage = BigDecimal.valueOf(stunden).divide(BigDecimal.valueOf(8));

        // extrahieren des leistungszeitraums in Form YYYY-MM-01
        LocalDate leistungszeitraum = t.getBeginn().withDayOfMonth(1).toLocalDate();

        return Dienstleistungsnachweis.builder().leistungszeitraum(leistungszeitraum).personentage(personentage).taetigkeit(t.getId())
                .korrektur(BigDecimal.ZERO).geprueft(false).kundenvertrag(t.getKundenvertrag()).partnervertrag(t.getPartnervertrag()).build();
    }

    private void dienstleistungsnachweisNotExistingForId(Long id) {
        throw new RuntimeException(String.format("Diensleistungsnachweis with Id %d does not exists!", id));
    }

    private List<AbstractMap.SimpleEntry<Dienstleistungsnachweis, AbstractMap.SimpleEntry<PartnervertragDto, KundenvertragDto>>>
    joinVertraegeMitDienstleistungsnachweis (List<Dienstleistungsnachweis> dlns, List<PartnervertragDto> pvs, List<KundenvertragDto> kvs) {
        Map<Long, PartnervertragDto> pvMap = pvs.stream()
                .collect(Collectors.toMap(PartnervertragDto::getId, Function.identity()));

        Map<Long, KundenvertragDto> kundenvertragMap = kvs.stream()
                .collect(Collectors.toMap(KundenvertragDto::getId, Function.identity()));

        return dlns.stream()
                .map(dln -> new AbstractMap.SimpleEntry<>(dln, new AbstractMap.SimpleEntry<>(pvMap.getOrDefault(dln.getPartnervertrag(), null),
                        kundenvertragMap.getOrDefault(dln.getKundenvertrag(), null)))).collect(Collectors.toList());
    }
}


