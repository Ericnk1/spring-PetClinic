package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Vet;

import java.util.List;
import java.util.Optional;

public interface VetService {

    /**
     * To create a new vet
     *
     * @param vet Vet
     */
    void createVet(Vet vet);


    /**
     * To get list of active vets
     *
     * @return list of vets
     */
    List<Vet> getActiveVets();

    /**
     * To find vet by first name and last name
     *
     * @param firstName Vet's first name
     * @param lastName Vet's last name
     * @return Optional of vet
     */
    Optional<Vet> findByFirstnameAndLastname(String firstName, String lastName);

    /**
     * To find vet by email
     *
     * @param email Vet's email
     * @return Optional of Vet
     */
    Optional<Vet> findVetByEmail(String email);

    /**
     * To get all vets
     *
     * @return list of vets
     */
    List<Vet> getAllVets();

    /**
     * To find vet by id
     *
     * @param id Vet id
     * @return optional of vet
     */
    Optional<Vet> findVetById(Long id);

    /**
     * To update an existing vet
     *
     * @param vet Vet
     */
    void updateVet(Vet vet);

    /**
     * To delete vet by id
     *
     * @param id Vet id
     */
    void deleteVetById(Long id);

    /**
     * To delete vet from database completely by id
     *
     * @param id Vet id
     */
    void fullDeleteVetById(Long id);

    /**
     * To restore vet by id
     *
     * @param id Vet id
     */
    void restoreVetById(Long id);
}
