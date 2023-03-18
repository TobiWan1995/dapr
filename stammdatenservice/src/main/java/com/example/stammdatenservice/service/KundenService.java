package com.example.stammdatenservice.service;

import com.example.stammdatenservice.entity.Kunde;
import com.example.stammdatenservice.entity.Mitarbeiter;

import java.util.List;

public interface KundenService {

    Kunde saveKunde(Kunde kunde);

    Kunde updateKunde(Kunde kunde);

    Kunde retrieveKundeById(Long id);

    List<Kunde> retrieveAllKunden();
    List<Kunde> retrieveKundenByIds(List<Long> ids);

    void publishAllKundenForSync();
}
