package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    Optional <PetType> findPetTypesById (Long id);
}
