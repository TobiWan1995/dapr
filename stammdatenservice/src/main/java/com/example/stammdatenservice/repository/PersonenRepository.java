package com.example.stammdatenservice.repository;

import com.example.stammdatenservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonenRepository<T extends Person> extends JpaRepository<T, Long> {
}
