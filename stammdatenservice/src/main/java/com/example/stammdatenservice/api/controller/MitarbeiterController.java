package com.example.stammdatenservice.api.controller;

import com.example.stammdatenservice.entity.Mitarbeiter;
import com.example.stammdatenservice.service.MitarbeiterService;
import com.example.stammdatenservice.util.ByteUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mitarbeiter")
@RequiredArgsConstructor
public class MitarbeiterController {

    private final MitarbeiterService mitarbeiterService;

    @PostMapping
    public ResponseEntity<Mitarbeiter> saveMitarbeiter(@RequestBody Mitarbeiter mitarbeiter) {
        return new ResponseEntity<>(mitarbeiterService.saveMitarbeiter(mitarbeiter), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mitarbeiter> updateMitarbeiter(@RequestBody Mitarbeiter mitarbeiter) {
        return new ResponseEntity<>(mitarbeiterService.updateMitarbeiter(mitarbeiter), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Mitarbeiter>> retrieveAllMitarbeiter() {
        return new ResponseEntity<>(mitarbeiterService.retrieveAllMitarbeiter(), HttpStatus.OK);
    }

    @PostMapping("/mitarbeiter")
    public ResponseEntity<List<Mitarbeiter>> retrieveMitarbeiter(@RequestBody List<Long> mitarbeiterIds) {
        return new ResponseEntity<>(mitarbeiterService.retrieveMitarbeiterByIds(mitarbeiterIds), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mitarbeiter> retrieveMitarbeiter(@PathVariable Long id) {
        return new ResponseEntity<>(mitarbeiterService.retrieveMitarbeiterById(id), HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity<HttpStatus> publishAllMitarbeiter() {
        mitarbeiterService.publishAllMitarbeiterForSync();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
