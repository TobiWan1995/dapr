package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.api.model.ProjektErfassbarkeitsAufstellung;

public interface ProjektErfassbarkeitsService {

    ProjektErfassbarkeitsAufstellung retrieveProjektErfassbarkeitsAufstellungForMitarbeiter(Long id);
}
