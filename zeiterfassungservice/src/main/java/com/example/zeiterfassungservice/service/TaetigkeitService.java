package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.enitity.Taetigkeit;

import java.time.LocalDate;
import java.util.List;

public interface TaetigkeitService {

    Taetigkeit saveTaetigkeit(Taetigkeit taetigkeit);

    Taetigkeit updateTaetigkeit(Taetigkeit taetigkeit);

    void deleteTaetigkeitById(Long id);

    List<Taetigkeit> retrieveTaetigkeitenForMitarbeiter(Long mitarbeiterId);

    List<Taetigkeit> retrieveTaetigkeitenForMitarbeiterInMonat(Long mitarbeiterId, LocalDate monat);

}
