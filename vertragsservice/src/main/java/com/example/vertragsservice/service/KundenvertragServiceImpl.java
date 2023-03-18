package com.example.vertragsservice.service;

import com.example.vertragsservice.dapr.InvocationClient;
import com.example.vertragsservice.api.model.KundenvertragAufstellung;
import com.example.vertragsservice.api.model.KundenvertragDto;
import com.example.vertragsservice.api.model.ProjektDto;
import com.example.vertragsservice.enitity.Kunde;
import com.example.vertragsservice.enitity.Kundenvertrag;
import com.example.vertragsservice.mapper.KundenvertragMapper;
import com.example.vertragsservice.repository.KundenRepository;
import com.example.vertragsservice.repository.KundenvertragRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service("kundenvertragService")
@RequiredArgsConstructor
public class KundenvertragServiceImpl implements KundenvertragService {

    private final InvocationClient invocationClient;
    private final KundenvertragRepository kundenvertragRepository;

    private final KundenRepository kundenRepository;
    private final KundenvertragMapper kundenvertragMapper;

    @Override
    public Kundenvertrag saveKundenvertrag(Kundenvertrag toSave) {
        return kundenvertragRepository.save(toSave);
    }

    @Override
    public Kundenvertrag updateKundenvertrag(Kundenvertrag toUpdate) {
        if (!kundenvertragRepository.existsById(toUpdate.getId()))
            kundenvertragNotExistingForId(toUpdate.getId());

        return kundenvertragRepository.save(toUpdate);
    }

    @Override
    public Kundenvertrag retrieveKundenvertragById(Long id) {
        return kundenvertragRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteKundenvertragById(Long id) {
        if (!kundenvertragRepository.existsById(id))
            kundenvertragNotExistingForId(id);

        kundenvertragRepository.deleteById(id);
    }

    @Override
    public List<Kundenvertrag> retrieveAllKundenvertrage() {
        return kundenvertragRepository.findAll();
    }

    @Override
    public List<Kundenvertrag> retrieveKundenvertrageByProjektId(Long id) {
        return kundenvertragRepository.findAllByProjekt(id);
    }

    @Override
    public KundenvertragAufstellung retrieveKundenvertragAufstellungForProjekt(Long projektId) {
        // retrieve Projekt via Service-Invocation-Component
        ProjektDto projekt = invocationClient.invokeProjektServiceForProjekt(projektId);

        // retrieve all kundenvertraege for KundenvertragAufstellung
        List<Kundenvertrag> kvsForProjekt = retrieveKundenvertrageByProjektId(projektId);

        // retrieve synced Kunden
        List<Long> kundenIds = kvsForProjekt.stream().map(Kundenvertrag::getKunde).toList();
        List<Kunde> kunden = kundenRepository.findAllById(kundenIds);

        // map each kundenvertrag according to kunde
        List<KundenvertragDto> kundenvertragDtos = joinKvsMitKunden(kvsForProjekt, kunden)
                .stream().map(entry -> kundenvertragMapper.toDto(entry.getKey(), entry.getValue())).collect(Collectors.toList());

        return new KundenvertragAufstellung(projekt, kundenvertragDtos);
    }

    @Override
    public List<Kundenvertrag> retrieveKundenvertraegeByIds(List<Long> ids) {
        return kundenvertragRepository.findAllById(ids);
    }

    private void kundenvertragNotExistingForId(Long id) {
        throw new RuntimeException(String.format("Kundenvertrag with Id %d does not exists!", id));
    }

    private List<AbstractMap.SimpleEntry<Kundenvertrag, Kunde>> joinKvsMitKunden(List<Kundenvertrag> kvs, List<Kunde> kunden) {
        Map<Long, Kunde> kundenMap = kunden.stream()
                .collect(Collectors.toMap(Kunde::getId, Function.identity()));

        return kvs.stream()
                .map(kv -> new AbstractMap.SimpleEntry<>(kv, kundenMap.getOrDefault(kv.getKunde(), null)))
                .collect(Collectors.toList());
    }
}
