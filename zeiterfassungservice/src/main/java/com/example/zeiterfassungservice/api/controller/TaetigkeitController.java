package com.example.zeiterfassungservice.api.controller;

import com.example.zeiterfassungservice.enitity.Taetigkeit;
import com.example.zeiterfassungservice.service.TaetigkeitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taetigkeit")
@RequiredArgsConstructor
public class TaetigkeitController {

    private final TaetigkeitService taetigkeitService;

    @PostMapping
    public ResponseEntity<Taetigkeit> saveTaetigkeit(@RequestBody Taetigkeit taetigkeit) {
        return new ResponseEntity<>(taetigkeitService.saveTaetigkeit(taetigkeit), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Taetigkeit> updateTaetigkeit(@RequestBody Taetigkeit taetigkeit) {
        return new ResponseEntity<>(taetigkeitService.updateTaetigkeit(taetigkeit), HttpStatus.OK);
    }

    @GetMapping("/mitarbeiter/{id}")
    public ResponseEntity<List<Taetigkeit>> retrieveTaetigkeitenForMitarbeiter(@PathVariable Long id) {
        return new ResponseEntity<>(taetigkeitService.retrieveTaetigkeitenForMitarbeiter(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaetigkeit(@PathVariable Long id) {
        taetigkeitService.deleteTaetigkeitById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
