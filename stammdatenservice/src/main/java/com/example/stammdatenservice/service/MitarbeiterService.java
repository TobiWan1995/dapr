package com.example.stammdatenservice.service;

import com.example.stammdatenservice.entity.Mitarbeiter;

import java.util.List;

public interface MitarbeiterService {

    Mitarbeiter saveMitarbeiter(Mitarbeiter mitarbeiter);

    Mitarbeiter updateMitarbeiter(Mitarbeiter mitarbeiter);

    Mitarbeiter retrieveMitarbeiterById(Long id);

    List<Mitarbeiter> retrieveAllMitarbeiter();
    List<Mitarbeiter> retrieveMitarbeiterByIds(List<Long> ids);

    void publishAllMitarbeiterForSync();
}
