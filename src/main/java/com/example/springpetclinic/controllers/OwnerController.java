package com.example.springpetclinic.controllers;

import com.example.springpetclinic.exceptions.NotFoundException;
import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.services.OwnerService;
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
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity<String> createOwner(@RequestBody Owner owner) {
        ownerService.createOwner(owner);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @RequestMapping("/active")
    public List<Owner> getActiveUsers(Model model) {return ownerService.getActiveOwners();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOwner(@RequestBody Owner owner) {
        ownerService.updateOwner(owner);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeleteOwner(@PathVariable Long id) {
        ownerService.fullDeleteOwnerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restoreOwner(@PathVariable Long id) {
        ownerService.restoreOwnerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/res/{id}")
    public Optional<Owner> findOwnerById(@PathVariable("id") Long id){
        return ownerService.findOwnerById(id);
    }
}
