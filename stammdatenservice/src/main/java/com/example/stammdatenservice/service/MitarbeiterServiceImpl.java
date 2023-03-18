package com.example.stammdatenservice.service;

import com.example.stammdatenservice.dapr.PublisherClient;
import com.example.stammdatenservice.entity.Mitarbeiter;
import com.example.stammdatenservice.repository.MitarbeiterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mitarbeiterservice")
@RequiredArgsConstructor
public class MitarbeiterServiceImpl implements MitarbeiterService {

    private final MitarbeiterRepository mitarbeiterRepository;

    private final PublisherClient publisherClient;

    @Override
    @Transactional
    public Mitarbeiter saveMitarbeiter(Mitarbeiter toSave) {
        Mitarbeiter saved = mitarbeiterRepository.save(toSave);
        publisherClient.publishMitarbeiterForSync(saved);

        return mitarbeiterRepository.save(saved);
    }

    @Override
    @Transactional
    public Mitarbeiter updateMitarbeiter(Mitarbeiter toUpdate) {
        if(!mitarbeiterRepository.existsById(toUpdate.getId()))
            mitarbeiterDoesNotExist(toUpdate.getId());

        Mitarbeiter updated = mitarbeiterRepository.save(toUpdate);
        publisherClient.publishMitarbeiterForSync(updated);

        return updated;
    }

    @Override
    public Mitarbeiter retrieveMitarbeiterById(Long id) {
        return mitarbeiterRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Mitarbeiter> retrieveAllMitarbeiter() {
        return mitarbeiterRepository.findAll();
    }

    @Override
    public List<Mitarbeiter> retrieveMitarbeiterByIds(List<Long> ids) {
        return mitarbeiterRepository.findAllById(ids);
    }

    @Override
    public void publishAllMitarbeiterForSync() {
        mitarbeiterRepository.findAll().forEach(publisherClient::publishMitarbeiterForSync);
    }

    private void mitarbeiterDoesNotExist(Long id) {
        throw new RuntimeException(String.format("Mitarbeiter with Id %d does not exists!", id));
    }
}
