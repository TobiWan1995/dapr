package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.api.model.MonatsabschlussCommand;
import com.example.zeiterfassungservice.dapr.PublisherClient;
import com.example.zeiterfassungservice.dapr.StateStoreClient;
import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;
import com.example.zeiterfassungservice.enitity.Taetigkeit;
import com.example.zeiterfassungservice.repository.MitarbeiterMonatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mitarbeitermonatservice")
@RequiredArgsConstructor
public class MitarbeiterMonatServiceImpl implements MitarbeiterMonatService {

    private final MitarbeiterMonatRepository mitarbeiterMonatRepository;
    private final TaetigkeitService taetigkeitService;
    private final PublisherClient publisherClient;
    private final StateStoreClient stateStoreClient;


    @Override
    @Transactional
    public MitarbeiterMonat schließeMitarbeiterMonatAb(MitarbeiterMonat mitarbeiterMonat) {
        // retrieve All Taetigkeiten in MitarbeiterMonat to publish
        List<Taetigkeit> taetigkeitenInMonth = taetigkeitService
                .retrieveTaetigkeitenForMitarbeiterInMonat(mitarbeiterMonat.getMitarbeiter(), mitarbeiterMonat.getMonat());

        // publish taetigkeitenInMonth for Leistungsnachweis-Service with Pub-Sub Component.
        publisherClient.publishTaetigkeitenForMitarbeiterMonatsAbschluss(new MonatsabschlussCommand(mitarbeiterMonat, taetigkeitenInMonth));

        // save MitarbeiterMonat in Store for Rollback on Error -> commit on success
        stateStoreClient.saveUncommitedMitarbeiterMonatInStore(mitarbeiterMonat);

        // return uncommitted MitarbeiterMonat for User-Experience -> message on fail later
        return mitarbeiterMonat;
    }

    @Override
    public List<MitarbeiterMonat> retrieveMitarbeiterMonatForMitarbeiter(Long id) {
        return mitarbeiterMonatRepository.findAllByMitarbeiter(id);
    }

    @Override
    public MitarbeiterMonat saveMitarbeiterMonat(MitarbeiterMonat mitarbeiterMonat) {
        return mitarbeiterMonatRepository.save(mitarbeiterMonat);
    }
}
