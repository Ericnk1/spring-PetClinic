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
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String telephoneNumber;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Pet> petList;

    private boolean isActive;
}
