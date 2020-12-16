package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // Optional<Pet> findPetOwner (Long id);
}
