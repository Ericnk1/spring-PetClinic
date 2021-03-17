package com.example.springpetclinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    private String email;

    //@JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> petList = new ArrayList<>();

    public void addPet(Pet pet) {
        petList.add(pet);
        pet.setOwner(this);
    }

    public void removePet(Pet pet) {
        petList.remove(pet);
        pet.setOwner(null);
    }

    private boolean isActive;
}
