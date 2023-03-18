package com.example.leistungsnachweisservice.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MitarbeiterMonatDto {

    Long mitarbeiter;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate monat;
}
