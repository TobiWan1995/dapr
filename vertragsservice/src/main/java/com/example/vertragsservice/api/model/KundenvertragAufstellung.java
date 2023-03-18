package com.example.vertragsservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KundenvertragAufstellung {

    private ProjektDto projekt;

    List<KundenvertragDto> kundenvertraege;
}
