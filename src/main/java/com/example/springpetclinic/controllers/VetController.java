package com.example.springpetclinic.controllers;


import com.example.springpetclinic.models.Vet;
import com.example.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vet")
public class VetController {

    @Autowired
    private VetService vetService;

    @PostMapping
    public ResponseEntity<String> createVet(@RequestBody Vet vet) {
        vetService.createVet(vet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Vet> getAllVets() {
        return vetService.getAllVets();
    }

    @RequestMapping("/active")
    public List<Vet> getActiveUsers(Model model) {return vetService.getActiveVets();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateVet(@RequestBody Vet vet) {
        vetService.updateVet(vet);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVet(@PathVariable Long id) {
        vetService.deleteVetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeleteVet(@PathVariable Long id) {
        vetService.fullDeleteVetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restoreVet(@PathVariable Long id) {
        vetService.restoreVetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/res/{id}")
    public ResponseEntity<String> findVetById(@PathVariable("id") Long id) {
        vetService.findVetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
