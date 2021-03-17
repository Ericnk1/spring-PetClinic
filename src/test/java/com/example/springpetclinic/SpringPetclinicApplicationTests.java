package com.example.springpetclinic;

import com.example.springpetclinic.models.Appointment;
import com.example.springpetclinic.models.Vet;
import com.example.springpetclinic.repositories.VetRepository;
import com.example.springpetclinic.services.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
class SpringPetclinicApplicationTests {

    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    void contextLoads() {
        Optional<Vet> byId = vetRepository.findById((long) 10);
        Assert.isTrue(byId.isPresent());
    }

    @Test
    void contextLoads1() {

        Optional<Appointment> appointmentById = appointmentService.findAppointmentById((long) 25);
        Assert.isTrue(appointmentById.isPresent());
    }

}
