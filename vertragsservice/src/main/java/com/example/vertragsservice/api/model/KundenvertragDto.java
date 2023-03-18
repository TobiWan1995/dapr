package com.example.vertragsservice.api.model;

import com.example.vertragsservice.enitity.Kunde;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KundenvertragDto {

    private LocalDate startdatum;

    private LocalDate enddatum;

    private Kunde kunde;

    private BigDecimal leistungssatz;
}
