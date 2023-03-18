package com.example.vertragsservice.service;

import com.example.vertragsservice.dapr.InvocationClient;
import com.example.vertragsservice.api.model.PartnervertragAufstellung;
import com.example.vertragsservice.api.model.PartnervertragDto;
import com.example.vertragsservice.api.model.ProjektDto;
import com.example.vertragsservice.enitity.Mitarbeiter;
import com.example.vertragsservice.enitity.Partnervertrag;
import com.example.vertragsservice.mapper.PartnervertragMapper;
import com.example.vertragsservice.repository.MitarbeiterRepository;
import com.example.vertragsservice.repository.PartnervertragRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service("projektService")
@RequiredArgsConstructor
public class PartnervertragServiceImpl implements PartnervertragService {
    private final PartnervertragRepository partnervertragRepository;
    private final PartnervertragMapper partnervertragMapper;
    private final InvocationClient invocationClient;
    private final MitarbeiterRepository mitarbeiterRepository;

    @Override
    public Partnervertrag savePartnervertrag(Partnervertrag toSave) {
        return partnervertragRepository.save(toSave);
    }

    @Override
    public Partnervertrag updatePartnervertrag(Partnervertrag toUpdate) {
        if (!partnervertragRepository.existsById(toUpdate.getId()))
            partnervertragNotExistingForId(toUpdate.getId());

        return partnervertragRepository.save(toUpdate);
    }

    @Override
    public Partnervertrag retrievePartnervertragById(Long id) {
        return partnervertragRepository.findById(id).orElseThrow();
    }

    @Override
    public void deletePartnervertragById(Long id) {
        if (!partnervertragRepository.existsById(id))
            partnervertragNotExistingForId(id);

        partnervertragRepository.deleteById(id);
    }

    @Override
    public List<Partnervertrag> retrieveAllPartnervertrage() {
        return partnervertragRepository.findAll();
    }

    @Override
    public List<Partnervertrag> retrievePartnervertraegeByIds(List<Long> ids) {
        return partnervertragRepository.findAllById(ids);
    }

    @Override
    public List<Partnervertrag> retrievePartnervertraegeForProjektId(Long id) {
        return partnervertragRepository.findAllByProjekt(id);
    }

    @Override
    public List<Partnervertrag> retrievePartnervertraefeForMitarbeiterId(Long id) {
        return partnervertragRepository.findAllByMitarbeiter(id);
    }

    @Override
    public PartnervertragAufstellung retrievePartnervertragAufstellungForProjekt(Long projektId) {
        // retrieve Projekt via Service-Invocation-Component
        ProjektDto projekt = invocationClient.invokeProjektServiceForProjekt(projektId);

        // retrieve all Pvs for PartnervertragAufstellung
        List<Partnervertrag> pvsForProjekt = retrievePartnervertraegeForProjektId(projektId);

        // retrieve Mitarbeiter via Service-Invocation-Component
        List<Long> mitarbeiterIds = pvsForProjekt.stream().map(Partnervertrag::getMitarbeiter).toList();
        List<Mitarbeiter> mitarbeiter = mitarbeiterRepository.findAllById(mitarbeiterIds);

        // map each Partnervertrag according to Mitarbeiter
        List<PartnervertragDto> partnervertragDtos = joinPvsMitMitarbeitern(pvsForProjekt, mitarbeiter)
                .stream().map(entry -> partnervertragMapper.toDto(entry.getKey(), entry.getValue())).collect(Collectors.toList());

        return new PartnervertragAufstellung(projekt, partnervertragDtos);
    }

    private void partnervertragNotExistingForId(Long id) {
        throw new RuntimeException(String.format("Partnervertrag with Id %d does not exists!", id));
    }

    private List<AbstractMap.SimpleEntry<Partnervertrag, Mitarbeiter>> joinPvsMitMitarbeitern(List<Partnervertrag> pvs, List<Mitarbeiter> mitarbeiter) {
        Map<Long, Mitarbeiter> mitarbeiterMap = mitarbeiter.stream()
                .collect(Collectors.toMap(Mitarbeiter::getId, Function.identity()));

        return pvs.stream()
                .map(pv -> new AbstractMap.SimpleEntry<>(pv, mitarbeiterMap.getOrDefault(pv.getMitarbeiter(), null)))
                .collect(Collectors.toList());
    }

}
