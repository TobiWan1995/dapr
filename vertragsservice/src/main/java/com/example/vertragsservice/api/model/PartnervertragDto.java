package com.example.vertragsservice.api.model;

import com.example.vertragsservice.enitity.Mitarbeiter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PartnervertragDto {

    private LocalDate startdatum;

    private LocalDate enddatum;

    private Mitarbeiter mitarbeiter;

    private BigDecimal tagessatz;
}
