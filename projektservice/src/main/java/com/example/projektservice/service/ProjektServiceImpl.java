package com.example.projektservice.service;

import com.example.projektservice.api.model.KundenProjekt;
import com.example.projektservice.dapr.PublisherClient;
import com.example.projektservice.enitity.Kunde;
import com.example.projektservice.enitity.Projekt;
import com.example.projektservice.repository.KundenRepository;
import com.example.projektservice.repository.ProjektRepository;
import io.dapr.client.DaprClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("projektService")
@RequiredArgsConstructor
public class ProjektServiceImpl implements ProjektService {

    private final DaprClient daprClient;
    private final ProjektRepository projektRepository;
    private final KundenRepository kundenRepository;

    private final PublisherClient publisherClient;

    @Override
    @Transactional
    public Projekt saveProjekt(Projekt toSave) {
        Projekt saved = projektRepository.save(toSave);
        publisherClient.publishProjektForSync(saved);
        return saved;
    }

    @Override
    @Transactional
    public Projekt updateProjekt(Projekt toUpdate) {
        if (!projektRepository.existsById(toUpdate.getId()))
            projektNotExistingForId(toUpdate.getId());

        Projekt updated = projektRepository.save(toUpdate);
        publisherClient.publishProjektForSync(updated);

        return updated;
    }

    @Override
    public Projekt retrieveProjektById(Long id) {
        return projektRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Projekt> retrieveAllProjekte() {
        return projektRepository.findAll();
    }

    @Override
    public List<Projekt> retrieveProjektByIds(List<Long> ids) {
        return projektRepository.findAllById(ids);
    }

    @Override
    public List<KundenProjekt> retrieveProjektAufstellungForKunden() {
        // retrieve Kunden synced from Kunden-Service
        List<Kunde> kunden = kundenRepository.findAll();

        // find matching Projekte for Kunden and map as KundenProjekt
        return kunden.stream()
                .map((kunde) -> new KundenProjekt(kunde, projektRepository.findAllByKundenId(kunde.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public void publishAllProjekteForSync() {
        projektRepository.findAll().forEach(publisherClient::publishProjektForSync);
    }

    private void projektNotExistingForId(Long id) {
        throw new RuntimeException(String.format("Projekt with Id %d does not exists!", id));
    }
}
