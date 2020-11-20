package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Consultant;

import java.util.List;
import java.util.Optional;

public interface ConsultantService {

    /**
     * To create a new consultant
     *
     * @param consultant Consultant
     */
    void createConsultant(Consultant consultant);

    /**
     * To find consultant by username and password
     *
     * @param email Consultant's email
     * @param password Consultant's password
     * @return Optional of consultant
     */
    Optional<Consultant> findByEmailAndPassword(String email, String password);

    /**
     * To get list of active consultants
     *
     * @return list of consultants
     */
    List<Consultant> getActiveConsultant();

    /**
     * To find user by username and password
     *
     * @param firstName Consultant's first name
     * @param lastName Consultant's last name
     * @return Optional of consultant
     */
    Optional<Consultant> findByFirstnameAndLastname(String firstName, String lastName);

    /**
     * To find consultant by by email
     *
     * @param email Consultant's email
     * @return Optional of Consultant
     */
    Optional<Consultant> findAdminByEmail(String email);

    /**
     * To get all consultants
     *
     * @return list of consultants
     */
    List<Consultant> getAllConsultants();

    /**
     * To find consultant by id
     *
     * @param id Consultant id
     * @return optional of consultant
     */
    Optional<Consultant> findConsultantById(Long id);

    /**
     * To update an existing consultant
     *
     * @param consultant Consultant
     */
    void updateConsultant(Consultant consultant);

    /**
     * To delete consultant by id
     *
     * @param id Consultant id
     */
    void deleteConsultantById(Long id);

    /**
     * To delete consultant from database completely by id
     *
     * @param id Consultant id
     */
    void fullDeleteConsultantById(Long id);

    /**
     * To restore consultant by id
     *
     * @param id Consultant id
     */
    void restoreConsultantById(Long id);
}
