package com.example.springpetclinic.repositories;

import com.example.springpetclinic.models.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmailAndPassword(String email, String password);

    Optional<Consultant> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Consultant> findConsultantByEmail(String email);
}
