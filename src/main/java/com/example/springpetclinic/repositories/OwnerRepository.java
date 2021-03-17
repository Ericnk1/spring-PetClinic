package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Owner> findOwnerByEmail(String email);

    Owner findOwnerById(Long id);

    //List<Pet> findPets(Long id);
}
