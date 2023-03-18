package com.example.projektservice.enitity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Projekt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String projektKuerzel;

    private String beschreibung;

    @JsonSerialize(using=LocalDateSerializer.class)
    private LocalDate startdatum;

    @JsonSerialize(using=LocalDateSerializer.class)
    private LocalDate enddatum;

    private Long kundenId;
}
