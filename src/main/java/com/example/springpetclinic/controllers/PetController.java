package com.example.springpetclinic.controllers;

import com.example.springpetclinic.exceptions.NotFoundException;
import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.models.Pet;
import com.example.springpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPet(@RequestBody Pet pet, Owner owner) {
        owner.addPet(pet);
        petService.createPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    /*@RequestMapping("/inactive")
    public List<Pet> getInactivePets(Model model) {return petService.getNonActivePets();}*/

    @RequestMapping("/active")
    public List<Pet> getActivePets(Model model) {return petService.getActivePets();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
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

    @GetMapping("/res/{id}")
    public Optional<Pet> findPetById(@PathVariable(value = "id") Long id){
        return petService.findPetById(id);
    }

    /*@GetMapping
    public Optional<Pet> findPetOwner(@PathVariable Long id) {
        return petService.findPetOwner(id);
    }*/
}
