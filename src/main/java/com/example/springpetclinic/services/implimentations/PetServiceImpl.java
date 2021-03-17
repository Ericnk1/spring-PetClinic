package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Owner;
import com.example.springpetclinic.models.Pet;
import com.example.springpetclinic.repositories.PetRepository;
import com.example.springpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void createPet(Pet pet) {
        pet.setActive(true);
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getActivePets() {
        return getAllPets().stream()
                .filter(Pet::isActive)
                .collect(Collectors.toList());
    }

    /*@Override
    public List<Pet> getNonActivePets() {
        return getAllPets().stream()
                .filter(Pet::isActive)
                .collect(Collectors.toList());
    }*/

    @Override
    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    /*@Override
    public Optional<Pet> findPetOwner(Long id) {
        return petRepository.findPetOwner(id);
    }*/

    @Override
    public void updatePet(Pet pet) {
        petRepository.saveAndFlush(pet);
    }

    @Override
    public void deletePetById(Long id) {
        findPetById(id).ifPresent(pet -> {
            pet.setActive(false);
            updatePet(pet);
        });
    }

    @Override
    public void fullDeletePetById(Long id) {
        findPetById(id).ifPresent(pet -> petRepository.delete(pet));
    }

    @Override
    public void restorePetById(Long id) {
        findPetById(id).ifPresent(pet -> {
            pet.setActive(true);
            updatePet(pet);
        });
    }
}
