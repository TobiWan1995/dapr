package com.example.vertragsservice.repository;

import com.example.vertragsservice.enitity.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {
}
