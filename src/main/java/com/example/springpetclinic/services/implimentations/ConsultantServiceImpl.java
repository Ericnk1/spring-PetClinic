package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Consultant;
import com.example.springpetclinic.repositories.ConsultantRepository;
import com.example.springpetclinic.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;

    @Override
    public void createConsultant(Consultant consultant) {
        consultant.setActive(true);
        consultantRepository.save(consultant);
    }

    @Override
    public Optional<Consultant> findByEmailAndPassword(String email, String password) {
        return consultantRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Consultant> getActiveConsultant() {
        return getAllConsultants().stream()
                .filter(Consultant::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Consultant> findByFirstnameAndLastname(String firstName, String lastName) {
        return consultantRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Consultant> findConsultantByEmail(String email) {
        return consultantRepository.findConsultantByEmail(email);
    }

    @Override
    public List<Consultant> getAllConsultants() {
        return consultantRepository.findAll();
    }

    @Override
    public Optional<Consultant> findConsultantById(Long id) {
        return consultantRepository.findById(id);
    }

    @Override
    public void updateConsultant(Consultant consultant) {
        consultantRepository.saveAndFlush(consultant);
    }

    @Override
    public void deleteConsultantById(Long id) {
        findConsultantById(id).ifPresent(consultant -> {
            consultant.setActive(false);
            updateConsultant(consultant);
        });
    }

    @Override
    public void fullDeleteConsultantById(Long id) {
        findConsultantById(id).ifPresent(consultant -> consultantRepository.delete(consultant));
    }

    @Override
    public void restoreConsultantById(Long id) {
        findConsultantById(id).ifPresent(consultant -> {
            consultant.setActive(true);
            updateConsultant(consultant);
        });
    }
}
