package com.example.stammdatenservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Mitarbeiter extends Person {

    private String vorname;

    private String nachname;

    private String kuerzel;

    private String rolle;

    private boolean ausgeschieden;
}
