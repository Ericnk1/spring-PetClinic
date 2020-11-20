package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    /**
     * To create a new admin
     *
     * @param admin Admin
     */
    void createAdmin(Admin admin);

    /**
     * To find user by username and password
     *
     * @param email Admin's email
     * @param password Admin's password
     * @return Optional of user
     */
    Optional<Admin> findByEmailAndPassword(String email, String password);

    /**
     * To get list of active admins
     *
     * @return list of admins
     */
    List<Admin> getActiveAdmins();

    /**
     * To find user by username and password
     *
     * @param firstName Admin's first name
     * @param lastName Admin's last name
     * @return Optional of admin
     */
    Optional<Admin> findByFirstnameAndLastname(String firstName, String lastName);

    /**
     * To find admin by email
     *
     * @param email Admin's email
     * @return Optional of Admin
     */
    Optional<Admin> findAdminByEmail(String email);

    /**
     * To get all admins
     *
     * @return list of admins
     */
    List<Admin> getAllAdmins();

    /**
     * To find admin by id
     *
     * @param id Admin id
     * @return optional of admin
     */
    Optional<Admin> findAdminById(Long id);

    /**
     * To update an existing admin
     *
     * @param admin Admin
     */
    void updateAdmin(Admin admin);

    /**
     * To delete admin by id
     *
     * @param id Admin id
     */
    void deleteAdminById(Long id);

    /**
     * To delete admin from database completely by id
     *
     * @param id Admin id
     */
    void fullDeleteAdminById(Long id);

    /**
     * To restore admin by id
     *
     * @param id Admin id
     */
    void restoreAdminById(Long id);
}
