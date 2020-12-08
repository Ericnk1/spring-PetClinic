package com.example.springpetclinic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    private String description;
    private Date date; //date of consultation
    private LocalTime time;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Consultant consultant;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Pet pet;

    private boolean isActive;
}
