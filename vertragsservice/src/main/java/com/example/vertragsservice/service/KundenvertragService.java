package com.example.vertragsservice.service;


import com.example.vertragsservice.api.model.KundenvertragAufstellung;
import com.example.vertragsservice.enitity.Kundenvertrag;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface KundenvertragService {

    Kundenvertrag saveKundenvertrag(Kundenvertrag kundenvertrag);

    Kundenvertrag updateKundenvertrag(Kundenvertrag kundenvertrag);

    Kundenvertrag retrieveKundenvertragById(Long id);

    void deleteKundenvertragById(Long id);

    List<Kundenvertrag> retrieveAllKundenvertrage();

    List<Kundenvertrag> retrieveKundenvertrageByProjektId(Long id);

    KundenvertragAufstellung retrieveKundenvertragAufstellungForProjekt(Long id);

    List<Kundenvertrag> retrieveKundenvertraegeByIds(List<Long> ids);
}
