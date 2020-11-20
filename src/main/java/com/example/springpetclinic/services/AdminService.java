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
     * To get all admins
     *
     * @return list of admins
     */
    List<Admin> getAllAdmins();
}
