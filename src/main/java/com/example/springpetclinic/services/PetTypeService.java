package com.example.springpetclinic.services;


import com.example.springpetclinic.models.PetType;

import java.util.List;
import java.util.Optional;

public interface PetTypeService {

    /**
     * To create a new petType
     *
     * @param petType PetType
     */
    void createPetType(PetType petType);

    /**
     * To get all the petTypes
     *
     * @return list of petTypes
     */
    List<PetType> getAllPetTypes();

    /**
     * To get list of active petTypes
     *
     * @return list of petTypes
     */
    List<PetType> getActivePetTypes();

    /**
     * To find petType by id
     *
     * @param id PetType id
     * @return optional of petType
     */
    Optional<PetType> findPetTypeById(Long id);

    /**
     * To update an existing petType
     *
     * @param petType PetType
     */
    void updatePetType(PetType petType);

    /**
     * To delete petType by id
     *
     * @param id PetType id
     */
    void deletePetTypeById(Long id);

    /**
     * To delete petType from database completely by id
     *
     * @param id PetType id
     */
    void fullDeletePetTypeById(Long id);

    /**
     * To restore petType by id
     *
     * @param id PetType id
     */
    void restorePetTypeById(Long id);
}
