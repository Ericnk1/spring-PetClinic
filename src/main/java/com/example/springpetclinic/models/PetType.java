package com.example.springpetclinic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long petTypeId;
    private String name;

    /*@OneToMany(cascade = CascadeType.MERGE)
    private List<Pet> petList;*/

    private boolean isActive;
}
