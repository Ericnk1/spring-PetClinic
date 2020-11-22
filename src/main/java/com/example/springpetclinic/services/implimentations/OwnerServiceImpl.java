package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.repositories.OwnerRepository;
import com.example.springpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void createOwner(Owner owner) {
        owner.setActive(true);
        ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findByEmailAndPassword(String email, String password) {
        return ownerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Owner> getActiveOwners() {
        return getAllOwners().stream()
                .filter(Owner::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Owner> findByFirstnameAndLastname(String firstName, String lastName) {
        return ownerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Owner> findOwnerByEmail(String email) {
        return ownerRepository.findOwnerByEmail(email);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.saveAndFlush(owner);
    }

    @Override
    public void deleteOwnerById(Long id) {
        findOwnerById(id).ifPresent(owner -> {
            owner.setActive(false);
            updateOwner(owner);
        });
    }

    @Override
    public void fullDeleteOwnerById(Long id) {
        findOwnerById(id).ifPresent(owner -> ownerRepository.delete(owner));
    }

    @Override
    public void restoreOwnerById(Long id) {
        findOwnerById(id).ifPresent(owner -> {
            owner.setActive(true);
            updateOwner(owner);
        });
    }
}
