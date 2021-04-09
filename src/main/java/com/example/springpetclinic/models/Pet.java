package com.example.springpetclinic.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth = new Date();
    String isVaccinated;

    private String petType;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = LAZY)
    private List<Appointment> appointment;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet )) return false;
        return id != null && id.equals(((Pet) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }*/

    //@JsonIgnore
    /*@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointmentList = new ArrayList<>();*/

    /*public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        appointment.setPet(this);
    }

    public void removeAppointment(Appointment appointment) {
        appointmentList.remove(appointment);
        appointment.setPet(null);
    }*/

    private boolean isActive;
}
