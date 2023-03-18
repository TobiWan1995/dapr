package com.example.vertragsservice.repository;

import com.example.vertragsservice.enitity.Vertrag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface VertragRepository<T extends Vertrag> extends JpaRepository<T, Long> {

    List<T> findAllByProjekt(Long projektId);
}
