package com.example.stammdatenservice.service;

import com.example.stammdatenservice.dapr.PublisherClient;
import com.example.stammdatenservice.entity.Kunde;
import com.example.stammdatenservice.repository.KundenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("kundenservice")
@RequiredArgsConstructor
public class KundenServiceImpl implements KundenService {

    private final KundenRepository kundenRepository;

    private final PublisherClient publisherClient;

    @Override
    @Transactional
    public Kunde saveKunde(Kunde toSave) {
        Kunde saved = kundenRepository.save(toSave);
        publisherClient.publishKundeForSync(saved);

        return kundenRepository.save(saved);
    }

    @Override
    @Transactional
    public Kunde updateKunde(Kunde toUpdate) {
        if(!kundenRepository.existsById(toUpdate.getId()))
            kundeDoesNotExist(toUpdate.getId());

        Kunde updated = kundenRepository.save(toUpdate);
        publisherClient.publishKundeForSync(updated);

        return updated;
    }

    @Override
    public Kunde retrieveKundeById(Long id) {
        return kundenRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Kunde> retrieveAllKunden() {
        return kundenRepository.findAll();
    }

    @Override
    public List<Kunde> retrieveKundenByIds(List<Long> ids) {
        return kundenRepository.findAllById(ids);
    }

    @Override
    public void publishAllKundenForSync() {
        kundenRepository.findAll().forEach(publisherClient::publishKundeForSync);
    }

    private void kundeDoesNotExist(Long id) {
        throw new RuntimeException(String.format("Kunde with Id %d does not exists!", id));
    }
}
