package com.example.leistungsnachweisservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonatsabschlussCommand {

    MitarbeiterMonatDto mitarbeiterMonat;

    List<TaetigkeitDto> taetigkeiten;
}
