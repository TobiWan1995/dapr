package com.example.leistungsnachweisservice.api.controller;

import com.example.leistungsnachweisservice.api.model.DienstleistungsnachweisDto;
import com.example.leistungsnachweisservice.enitity.Dienstleistungsnachweis;
import com.example.leistungsnachweisservice.service.DienstleistungsnachweisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dienstleistungsnachweis")
@RequiredArgsConstructor
public class DienstleistungsnachweisController {

    private final DienstleistungsnachweisService dienstleistungsnachweisService;

    @GetMapping
    public ResponseEntity<List<DienstleistungsnachweisDto>> retrieveDienstleistungsnachweise() {
        return new ResponseEntity<>(dienstleistungsnachweisService.retrieveAllDienstleistungsnachweise(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DienstleistungsnachweisDto> updateDienstleistungsnachweis(@RequestBody Dienstleistungsnachweis dienstleistungsnachweis){
        return new ResponseEntity<>(dienstleistungsnachweisService.updateDienstleistungsnachweis(dienstleistungsnachweis), HttpStatus.OK);
    }

}
