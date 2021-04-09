package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.Appointment;
import com.example.springpetclinic.repositories.AppointmentRepository;
import com.example.springpetclinic.services.AppointmentService;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @RequestMapping("/active")
    public List<Appointment> getActiveUsers(Model model) {return appointmentService.getActiveAppointments();}

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAppointment(@RequestBody Appointment appointment) {
        appointmentService.updateAppointment(appointment);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<String> fullDeleteAppointment(@PathVariable Long id) {
        appointmentService.fullDeleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<String> restoreAppointment(@PathVariable Long id) {
        appointmentService.restoreAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list/{petId}")
    public ResponseEntity<String> findAppointmentByPetId(@PathVariable Long petId) {
        appointmentService.findAppointmentByPetId(petId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/res/{id}")
    public Optional<Appointment> findAppointmentById(@PathVariable("id") Long id){
        return appointmentService.findAppointmentById(id);
    }
}
