package com.example.zeiterfassungservice.api.controller;

import com.example.zeiterfassungservice.api.model.ProjektErfassbarkeitsAufstellung;
import com.example.zeiterfassungservice.service.ProjektErfassbarkeitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projekterfassbarkeit")
@RequiredArgsConstructor
public class ProjektErfassbarkeitController {

    private final ProjektErfassbarkeitsService projektErfassbarkeitsService;

    @GetMapping("/mitarbeiter/{id}")
    public ResponseEntity<ProjektErfassbarkeitsAufstellung> retrieveProjektErfassbarkeitsAufstellungForMitarbeiter(@PathVariable Long id) {
        return new ResponseEntity<>(projektErfassbarkeitsService.retrieveProjektErfassbarkeitsAufstellungForMitarbeiter(id), HttpStatus.OK);
    }
}
