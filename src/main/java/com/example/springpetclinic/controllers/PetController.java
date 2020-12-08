package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.Pet;
import com.example.springpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<String> createPet(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeletePet(@PathVariable Long id) {
        petService.fullDeletePetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restorePet(@PathVariable Long id) {
        petService.restorePetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
