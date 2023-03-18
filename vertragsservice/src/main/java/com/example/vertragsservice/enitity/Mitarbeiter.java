package com.example.vertragsservice.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Mitarbeiter {

    @Id
    private Long id;

    private String vorname;

    private String nachname;

    private String kuerzel;

    private String rolle;

    private boolean ausgeschieden;
}
