package com.example.stammdatenservice.repository;

import com.example.stammdatenservice.entity.Kunde;
import org.springframework.stereotype.Repository;

@Repository
public interface KundenRepository extends PersonenRepository<Kunde> {
}
