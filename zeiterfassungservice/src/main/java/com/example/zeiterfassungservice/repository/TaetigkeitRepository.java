package com.example.zeiterfassungservice.repository;

import com.example.zeiterfassungservice.enitity.Taetigkeit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaetigkeitRepository extends JpaRepository<Taetigkeit, Long> {

        List<Taetigkeit> findAllByMitarbeiter(Long id);

        List<Taetigkeit> findAllByMitarbeiterAndBeginnBetween(Long id, LocalDateTime von, LocalDateTime bis);
}
