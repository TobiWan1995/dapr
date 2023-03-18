package com.example.zeiterfassungservice.api.model;

import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;
import com.example.zeiterfassungservice.enitity.Taetigkeit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonatsabschlussCommand {

    MitarbeiterMonat mitarbeiterMonat;

    List<Taetigkeit> taetigkeiten;
}
