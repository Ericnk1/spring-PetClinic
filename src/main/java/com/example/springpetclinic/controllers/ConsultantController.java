package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.Consultant;
import com.example.springpetclinic.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @PostMapping
    public ResponseEntity<String> createConsultant(@RequestBody Consultant consultant) {
        consultantService.createConsultant(consultant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Consultant> getAllConsultants() {
        return consultantService.getAllConsultants();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateConsultant(@RequestBody Consultant consultant) {
        consultantService.updateConsultant(consultant);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteConsultant(@PathVariable Long id) {
        consultantService.deleteConsultantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeleteConsultant(@PathVariable Long id) {
        consultantService.fullDeleteConsultantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restoreConsultant(@PathVariable Long id) {
        consultantService.restoreConsultantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
