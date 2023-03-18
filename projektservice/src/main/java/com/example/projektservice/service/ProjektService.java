package com.example.projektservice.service;

import com.example.projektservice.api.model.KundenProjekt;
import com.example.projektservice.enitity.Projekt;

import java.util.List;

public interface ProjektService {

    Projekt saveProjekt(Projekt projekt);

    Projekt updateProjekt(Projekt projekt);

    Projekt retrieveProjektById(Long id);

    List<Projekt> retrieveAllProjekte();

    List<Projekt> retrieveProjektByIds(List<Long> ids);

    List<KundenProjekt> retrieveProjektAufstellungForKunden();

    void publishAllProjekteForSync();
}
