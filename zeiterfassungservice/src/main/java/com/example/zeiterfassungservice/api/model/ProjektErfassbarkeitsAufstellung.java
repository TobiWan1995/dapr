package com.example.zeiterfassungservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjektErfassbarkeitsAufstellung {

    private List<KundenvertragAufstellung> kundenvertragAufstellungen;

    private List<PartnervertragDto> partnervertraege;
}
