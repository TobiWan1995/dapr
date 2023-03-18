package com.example.projektservice.api.model;

import com.example.projektservice.enitity.Kunde;
import com.example.projektservice.enitity.Projekt;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KundenProjekt {

    private Kunde kunde;

    private List<Projekt> kundenProjekte;
}
