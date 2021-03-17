package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    /**
     * To create a new pet
     *
     * @param pet Pet
     */
    void createPet(Pet pet);

    /**
     * To get all the pets
     *
     * @return list of pets
     */
    List<Pet> getAllPets();

    /**
     * To get list of active pets
     *
     * @return list of pets
     */
    List<Pet> getActivePets();

    //List<Pet> getNonActivePets();

    /**
     * To find pet by id
     *
     * @param id Pet id
     * @return optional of pet
     */
    Optional<Pet> findPetById(Long id);

    // Optional<Pet> findPetOwner(Long id);

    /**
     * To update an existing pet
     *
     * @param pet Pet
     */
    void updatePet(Pet pet);

    /**
     * To delete pet by id
     *
     * @param id Pet id
     */
    void deletePetById(Long id);

    /**
     * To delete pet from database completely by id
     *
     * @param id Pet id
     */
    void fullDeletePetById(Long id);

    /**
     * To restore pet by id
     *
     * @param id Pet id
     */
    void restorePetById(Long id);
}
