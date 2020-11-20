package com.example.springpetclinic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultantId;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Appointment> appointmentList;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Pet> petList;
}
