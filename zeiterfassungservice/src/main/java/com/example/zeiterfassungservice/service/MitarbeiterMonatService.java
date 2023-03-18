package com.example.zeiterfassungservice.service;

import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;

import java.util.List;

public interface MitarbeiterMonatService {

    MitarbeiterMonat schließeMitarbeiterMonatAb(MitarbeiterMonat mitarbeiterMonat);

    List<MitarbeiterMonat> retrieveMitarbeiterMonatForMitarbeiter(Long id);

    MitarbeiterMonat saveMitarbeiterMonat(MitarbeiterMonat mitarbeiterMonat);
}
