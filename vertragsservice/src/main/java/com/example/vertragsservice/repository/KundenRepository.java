package com.example.vertragsservice.repository;

import com.example.vertragsservice.enitity.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundenRepository extends JpaRepository<Kunde, Long> {
}
