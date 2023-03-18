package com.example.vertragsservice.api.controller;

import com.example.vertragsservice.api.model.KundenvertragAufstellung;
import com.example.vertragsservice.enitity.Kundenvertrag;
import com.example.vertragsservice.enitity.Partnervertrag;
import com.example.vertragsservice.service.KundenvertragService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kundenvertrag")
@RequiredArgsConstructor
public class KundenvertragController {
    private final KundenvertragService kundenvertragService;

    @PostMapping
    public ResponseEntity<Kundenvertrag> saveKundenvertrag(@RequestBody Kundenvertrag kundenvertrag) {
        return new ResponseEntity<>(kundenvertragService.saveKundenvertrag(kundenvertrag), HttpStatus.OK);
    }

    @PutMapping ResponseEntity<Kundenvertrag> updateKundenvertrag(@RequestBody Kundenvertrag kundenvertrag) {
        return new ResponseEntity<>(kundenvertragService.updateKundenvertrag(kundenvertrag), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kundenvertrag> retrieveKundenvertrag(Long id) {
        return new ResponseEntity<>(kundenvertragService.retrieveKundenvertragById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKundenvertrag(@PathVariable Long id) {
        kundenvertragService.deleteKundenvertragById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Kundenvertrag>> retrieveAllKundenvertrage() {
        return new ResponseEntity<>(kundenvertragService.retrieveAllKundenvertrage(), HttpStatus.OK);
    }

    @GetMapping("/projekt/{id}")
    public ResponseEntity<KundenvertragAufstellung> retrieveKundenvertragsAufstellungForProjekt(@PathVariable Long id) {
        return new ResponseEntity<>(kundenvertragService.retrieveKundenvertragAufstellungForProjekt(id), HttpStatus.OK);
    }

    @PostMapping("/kundenvertraege")
    public ResponseEntity<List<Kundenvertrag>> retrievePartnervertraege(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(kundenvertragService.retrieveKundenvertraegeByIds(ids), HttpStatus.OK);
    }
}
