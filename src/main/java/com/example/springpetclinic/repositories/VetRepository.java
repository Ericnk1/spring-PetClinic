package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

    Optional<Vet> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Vet> findVetByEmail(String email);
}
