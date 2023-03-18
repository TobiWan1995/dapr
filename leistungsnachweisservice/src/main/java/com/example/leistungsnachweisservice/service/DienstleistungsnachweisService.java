package com.example.leistungsnachweisservice.service;


import com.example.leistungsnachweisservice.api.model.DienstleistungsnachweisDto;
import com.example.leistungsnachweisservice.api.model.MonatsabschlussCommand;
import com.example.leistungsnachweisservice.enitity.Dienstleistungsnachweis;

import java.util.List;

public interface DienstleistungsnachweisService {

    Void createDienstleistungsNachweiseForMonatsabschluss(MonatsabschlussCommand monatsabschlussCommand);

    List<DienstleistungsnachweisDto> retrieveAllDienstleistungsnachweise();

    DienstleistungsnachweisDto updateDienstleistungsnachweis(Dienstleistungsnachweis dienstleistungsnachweis);
}
