package com.example.leistungsnachweisservice.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnervertragDto {

    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startdatum;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate enddatum;

    private Long mitarbeiter;

    private BigDecimal tagessatz;

    private Long projekt;
}
