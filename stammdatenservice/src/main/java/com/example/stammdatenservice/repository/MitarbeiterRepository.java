package com.example.stammdatenservice.repository;

import com.example.stammdatenservice.entity.Mitarbeiter;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends PersonenRepository<Mitarbeiter> {
}
