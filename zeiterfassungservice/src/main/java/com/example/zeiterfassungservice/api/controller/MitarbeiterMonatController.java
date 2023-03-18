package com.example.zeiterfassungservice.api.controller;

import com.example.zeiterfassungservice.enitity.MitarbeiterMonat;
import com.example.zeiterfassungservice.service.MitarbeiterMonatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mitarbeitermonat")
@RequiredArgsConstructor
public class MitarbeiterMonatController {

    private final MitarbeiterMonatService mitarbeiterMonatService;

    @GetMapping("/mitarbeiter/{id}")
    public ResponseEntity<List<MitarbeiterMonat>> retrieveMitarbeiterMonatForMitarbeiter(@PathVariable Long id) {
        return new ResponseEntity<>(mitarbeiterMonatService.retrieveMitarbeiterMonatForMitarbeiter(id), HttpStatus.OK);
    }

    @PostMapping("/abschluss")
    public ResponseEntity<MitarbeiterMonat> schließeMitarbeiterMonatAb(@RequestBody MitarbeiterMonat mitarbeiterMonat) {
        return new ResponseEntity<>(mitarbeiterMonatService.schließeMitarbeiterMonatAb(mitarbeiterMonat), HttpStatus.OK);
    }
}
