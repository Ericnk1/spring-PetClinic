package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Vet;
import com.example.springpetclinic.repositories.VetRepository;
import com.example.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetServiceImpl implements VetService {

    @Autowired
    private VetRepository vetRepository;

    @Override
    public void createVet(Vet vet) {
        vet.setActive(true);
        vetRepository.save(vet);
    }

    @Override
    public List<Vet> getActiveVets() {
        return getAllVets().stream()
                .filter(Vet::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vet> findByFirstnameAndLastname(String firstName, String lastName) {
        return vetRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Vet> findVetByEmail(String email) {
        return vetRepository.findVetByEmail(email);
    }

    @Override
    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    @Override
    public Optional<Vet> findVetById(Long id) {
        return vetRepository.findById(id);
    }

    @Override
    public void updateVet(Vet vet) {
        vetRepository.saveAndFlush(vet);
    }

    @Override
    public void deleteVetById(Long id) {
        findVetById(id).ifPresent(vet -> {
            vet.setActive(false);
            updateVet(vet);
        });
    }

    @Override
    public void fullDeleteVetById(Long id) {
        findVetById(id).ifPresent(vet -> vetRepository.delete(vet));
    }

    @Override
    public void restoreVetById(Long id) {
        findVetById(id).ifPresent(vet -> {
            vet.setActive(true);
            updateVet(vet);
        });
    }
}
