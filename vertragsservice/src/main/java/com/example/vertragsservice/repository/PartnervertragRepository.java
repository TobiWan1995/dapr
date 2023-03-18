package com.example.vertragsservice.repository;

import com.example.vertragsservice.enitity.Partnervertrag;

import java.util.List;


public interface PartnervertragRepository extends VertragRepository<Partnervertrag> {

    List<Partnervertrag> findAllByMitarbeiter(Long id);
}
