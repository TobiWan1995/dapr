package com.example.leistungsnachweisservice.repository;

import com.example.leistungsnachweisservice.enitity.Dienstleistungsnachweis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DienstleistungsnachweisRepository extends JpaRepository<Dienstleistungsnachweis, Long> {
}
