package com.example.zeiterfassungservice.repository;

import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MitarbeiterMonatRepository extends JpaRepository<MitarbeiterMonat, Long> {

    List<MitarbeiterMonat> findAllByMitarbeiter(Long id);
}
