package com.example.leistungsnachweisservice.enitity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@AllArgsConstructor
public class Dienstleistungsnachweis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long partnervertrag;

    private Long kundenvertrag;

    private Long taetigkeit;

    private boolean geprueft;

    private BigDecimal personentage;

    private BigDecimal korrektur;

    private LocalDate leistungszeitraum;
}
