package com.example.leistungsnachweisservice.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaetigkeitDto {

    private Long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime beginn;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime ende;

    private Long pause;

    private String typ;

    private Long projekt;

    private Long mitarbeiter;

    private Long partnervertrag;

    private Long kundenvertrag;
}
