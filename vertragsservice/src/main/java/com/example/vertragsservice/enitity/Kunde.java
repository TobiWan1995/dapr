package com.example.vertragsservice.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@AllArgsConstructor
public class Kunde {

    @Id
    private Long id;

    private String beschreibung;

    private String firmenname;

    private String rechtsform;
}
