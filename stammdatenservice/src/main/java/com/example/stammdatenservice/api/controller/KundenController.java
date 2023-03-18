package com.example.stammdatenservice.api.controller;

import com.example.stammdatenservice.entity.Kunde;
import com.example.stammdatenservice.service.KundenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunde")
@RequiredArgsConstructor
public class KundenController {

    private final KundenService kundenService;

    @PostMapping
    public ResponseEntity<Kunde> saveKunde(@RequestBody Kunde kunde) {
        return new ResponseEntity<>(kundenService.saveKunde(kunde), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Kunde> updateKunde(@RequestBody Kunde kunde) {
        return new ResponseEntity<>(kundenService.updateKunde(kunde), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Kunde>> retrieveKunden() {
        return new ResponseEntity<>(kundenService.retrieveAllKunden(), HttpStatus.OK);
    }

    @PostMapping("/kunden")
    public ResponseEntity<List<Kunde>> retrieveKunden(@RequestBody List<Long> kundenIds) {
        return new ResponseEntity<>(kundenService.retrieveKundenByIds(kundenIds), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kunde> retrieveKunde(@PathVariable Long id) {
        return new ResponseEntity<>(kundenService.retrieveKundeById(id), HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity<HttpStatus> publishAllKunden() {
        kundenService.publishAllKundenForSync();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
