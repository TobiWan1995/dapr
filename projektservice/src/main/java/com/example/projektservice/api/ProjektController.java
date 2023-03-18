package com.example.projektservice.api;

import com.example.projektservice.api.model.KundenProjekt;
import com.example.projektservice.enitity.Projekt;
import com.example.projektservice.service.ProjektService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projekt")
@RequiredArgsConstructor
public class ProjektController {
    private final ProjektService projektService;

    @PostMapping
    public ResponseEntity<Projekt> saveProjekt(@RequestBody Projekt projekt) {
        return new ResponseEntity<>(projektService.saveProjekt(projekt), HttpStatus.OK);
    }

    @PutMapping ResponseEntity<Projekt> updateProjekt(@RequestBody Projekt projekt) {
        return new ResponseEntity<>(projektService.updateProjekt(projekt), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projekt> retrieveProjekt(@PathVariable Long id) {
        return new ResponseEntity<>(projektService.retrieveProjektById(id), HttpStatus.OK);
    }

    @PostMapping("/projekte")
    public ResponseEntity<List<Projekt>> retrieveProjekte(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(projektService.retrieveProjektByIds(ids), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Projekt>> retrieveAllProjekte() {
        return new ResponseEntity<>(projektService.retrieveAllProjekte(), HttpStatus.OK);
    }

    @GetMapping("/kunden")
    public ResponseEntity<List<KundenProjekt>> retrieveKundenProjekte() {
        return new ResponseEntity<>(projektService.retrieveProjektAufstellungForKunden(), HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity<HttpStatus> publishAllprojekteForSync() {
        projektService.publishAllProjekteForSync();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
