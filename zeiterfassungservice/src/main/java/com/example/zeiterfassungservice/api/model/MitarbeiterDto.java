package com.example.zeiterfassungservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MitarbeiterDto {

    private Long id;

    private String kuerzel;

    private String vorname;

    private String nachname;
}
