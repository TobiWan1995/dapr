package com.example.vertragsservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PartnervertragAufstellung {

    private ProjektDto projekt;

    private List<PartnervertragDto> partnervertraege;
}
