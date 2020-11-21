package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByEmailAndPassword(String email, String password);

    Optional<Owner> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Owner> findOwnerByEmail(String email);
}
