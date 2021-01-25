package com.example.springpetclinic.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date(); //date of consultation
    private LocalTime time;

    @JsonIgnore
    @ManyToOne//(cascade = CascadeType.ALL)
    private Pet pet;
    private boolean isActive;
}
