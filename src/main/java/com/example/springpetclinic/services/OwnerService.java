package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    /**
     * To create a new owner
     *
     * @param owner Owner
     */
    void createOwner(Owner owner);

    /**
     * To find user by username and password
     *
     * @param email Owner's email
     * @param password Owner's password
     * @return Optional of owner
     */
    Optional<Owner> findByEmailAndPassword(String email, String password);

    /**
     * To get list of active owners
     *
     * @return list of owners
     */
    List<Owner> getActiveOwners();

    /**
     * To find user by username and password
     *
     * @param firstName Owner's first name
     * @param lastName Owner's last name
     * @return Optional of owner
     */
    Optional<Owner> findByFirstnameAndLastname(String firstName, String lastName);

    /**
     * To find owner by email
     *
     * @param email Owner's email
     * @return Optional of Owner
     */
    Optional<Owner> findOwnerByEmail(String email);

    /**
     * To get all owners
     *
     * @return list of owners
     */
    List<Owner> getAllOwners();

    /**
     * To find owner by id
     *
     * @param id Owner id
     * @return optional of owner
     */
    Optional<Owner> findOwnerById(Long id);

    /**
     * To update an existing owner
     *
     * @param owner Owner
     */
    void updateOwner(Owner owner);

    /**
     * To delete owner by id
     *
     * @param id Owner id
     */
    void deleteOwnerById(Long id);

    /**
     * To delete owner from database completely by id
     *
     * @param id Owner id
     */
    void fullDeleteOwnerById(Long id);

    /**
     * To restore owner by id
     *
     * @param id Owner id
     */
    void restoreOwnerById(Long id);
}
