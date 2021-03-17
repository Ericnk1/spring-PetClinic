package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmailAndPassword(String email, String password);

    Optional<Admin> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Admin> findAdminByEmail(String email);
    Admin findAdminById(Long id);
}
