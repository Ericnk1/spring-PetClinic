package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Pet;
import com.example.springpetclinic.models.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    //List<PetType> findPetTypes();
    // Optional<Pet> findPetOwner (Long id);
    Pet findPetById (Long id);

    //List<Pet> findByActiveFalse();
}
