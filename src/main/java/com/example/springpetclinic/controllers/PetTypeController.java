package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.PetType;
import com.example.springpetclinic.services.PetTypeService;
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
@RequestMapping("/petType")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;

    @PostMapping
    public ResponseEntity<String> createPetType(@RequestBody PetType petType) {
        petTypeService.createPetType(petType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<PetType> getAllPetTypes() {
        return petTypeService.getAllPetTypes();
    }

    @RequestMapping("/active")
    public List<PetType> getActivePetTypes(Model model) {return petTypeService.getActivePetTypes();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePetType(@RequestBody PetType petType) {
        petTypeService.updatePetType(petType);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePetType(@PathVariable Long id) {
        petTypeService.deletePetTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeletePetType(@PathVariable Long id) {
        petTypeService.fullDeletePetTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restorePetType(@PathVariable Long id) {
        petTypeService.restorePetTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/res/{id}")
    public ResponseEntity<String> findPetTypeById(@ModelAttribute("id") Long id) {
        petTypeService.findPetTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
