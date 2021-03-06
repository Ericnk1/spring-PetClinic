package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    //List<PetType> findPetTypes();
    // Optional<Pet> findPetOwner (Long id);
    Pet findPetById (Long id);

    //List<Pet> findByActiveFalse();
}
