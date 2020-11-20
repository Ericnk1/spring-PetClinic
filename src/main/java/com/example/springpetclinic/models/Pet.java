package com.example.springpetclinic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    Date dateOfBirth;
    boolean isVaccinated;

    @ManyToOne(cascade = CascadeType.MERGE)
    private PetType petType;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Owner owner;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Vet vet;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Consultant consultant;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Appointment> appointmentList;
}
