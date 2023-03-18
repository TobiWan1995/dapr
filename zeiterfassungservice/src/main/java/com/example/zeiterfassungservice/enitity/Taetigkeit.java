package com.example.zeiterfassungservice.enitity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taetigkeit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime beginn;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime ende;

    private Long pause;

    private String typ;

    private Long projekt;

    private Long mitarbeiter;

    private Long partnervertrag;

    private Long kundenvertrag;
}
