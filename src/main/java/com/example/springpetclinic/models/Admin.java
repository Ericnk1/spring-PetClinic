package com.example.springpetclinic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String password;
    private boolean isActive;
}
