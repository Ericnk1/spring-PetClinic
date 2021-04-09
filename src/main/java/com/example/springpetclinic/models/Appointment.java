package com.example.springpetclinic.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
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
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment )) return false;
        return id != null && id.equals(((Appointment) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }*/

    private boolean isActive;
}
