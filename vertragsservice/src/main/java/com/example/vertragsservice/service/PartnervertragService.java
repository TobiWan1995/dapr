package com.example.vertragsservice.service;

import com.example.vertragsservice.api.model.PartnervertragAufstellung;
import com.example.vertragsservice.enitity.Partnervertrag;

import java.util.List;

public interface PartnervertragService {

    Partnervertrag savePartnervertrag(Partnervertrag projekt);

    Partnervertrag updatePartnervertrag(Partnervertrag projekt);

    Partnervertrag retrievePartnervertragById(Long id);

    void deletePartnervertragById(Long id);

    List<Partnervertrag> retrieveAllPartnervertrage();

    List<Partnervertrag> retrievePartnervertraegeByIds(List<Long> ids);

    List<Partnervertrag> retrievePartnervertraegeForProjektId(Long id);

    List<Partnervertrag> retrievePartnervertraefeForMitarbeiterId(Long id);

    PartnervertragAufstellung retrievePartnervertragAufstellungForProjekt(Long id);
}
