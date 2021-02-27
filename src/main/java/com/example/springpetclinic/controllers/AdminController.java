package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.Admin;
import com.example.springpetclinic.services.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        adminService.createAdmin(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @RequestMapping("/active")
    public List<Admin> getActiveUsers(Model model) {return adminService.getActiveAdmins();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeleteAdmin(@PathVariable Long id) {
        adminService.fullDeleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restoreAdmin(@PathVariable("id") Long id) {
        adminService.restoreAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
