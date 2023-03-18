package com.example.vertragsservice.api.controller;

import com.example.vertragsservice.api.model.PartnervertragAufstellung;
import com.example.vertragsservice.enitity.Partnervertrag;
import com.example.vertragsservice.service.PartnervertragService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partnervertrag")
@RequiredArgsConstructor
public class PartnervertragController {
    private final PartnervertragService partnervertragService;

    @PostMapping
    public ResponseEntity<Partnervertrag> savePartnervertrag(@RequestBody Partnervertrag partnervertrag) {
        return new ResponseEntity<>(partnervertragService.savePartnervertrag(partnervertrag), HttpStatus.OK);
    }

    @PutMapping ResponseEntity<Partnervertrag> updatePartnervertrag(@RequestBody Partnervertrag partnervertrag) {
        return new ResponseEntity<>(partnervertragService.updatePartnervertrag(partnervertrag), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partnervertrag> retrievePartnervertrag(Long id) {
        return new ResponseEntity<>(partnervertragService.retrievePartnervertragById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartnervertrag(Long id) {
        partnervertragService.deletePartnervertragById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Partnervertrag>> retrieveAllPartnervertrage() {
        return new ResponseEntity<>(partnervertragService.retrieveAllPartnervertrage(), HttpStatus.OK);
    }

    @PostMapping("/partnervertraege")
    public ResponseEntity<List<Partnervertrag>> retrievePartnervertraege(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(partnervertragService.retrievePartnervertraegeByIds(ids), HttpStatus.OK);
    }

    @GetMapping("/mitarbeiter/{id}")
    public ResponseEntity<List<Partnervertrag>> retrievePartnervertrageForMitarbeiter(@PathVariable Long id) {
        return new ResponseEntity<>(partnervertragService.retrievePartnervertraefeForMitarbeiterId(id), HttpStatus.OK);
    }

    @GetMapping("/projekt/{id}")
    public ResponseEntity<PartnervertragAufstellung> retrievePartnervertragAufstellungForProjekt(@PathVariable Long id) {
        return new ResponseEntity<>(partnervertragService.retrievePartnervertragAufstellungForProjekt(id), HttpStatus.OK);
    }
}
