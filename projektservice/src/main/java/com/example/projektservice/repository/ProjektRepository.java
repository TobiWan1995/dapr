package com.example.projektservice.repository;

import com.example.projektservice.enitity.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjektRepository extends JpaRepository<Projekt, Long> {

    List<Projekt> findAllByKundenId(Long kundenId);
}
