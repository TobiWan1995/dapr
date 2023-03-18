package com.example.leistungsnachweisservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DienstleistungsnachweisDto {

    private PartnervertragDto partnervertrag;

    private KundenvertragDto kundenvertrag;

    private boolean geprueft;

    private BigDecimal personentage;

    private BigDecimal korrektur;

    private LocalDate leistungszeitraum;
}
