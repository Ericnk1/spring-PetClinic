package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.PetType;
import com.example.springpetclinic.repositories.PetTypeRepository;
import com.example.springpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public void createPetType(PetType petType) {
        petType.setActive(true);
        petTypeRepository.save(petType);
    }

    @Override
    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }

    @Override
    public List<PetType> getActivePetTypes() {
        return getAllPetTypes().stream()
                .filter(PetType::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PetType> findPetTypeById(Long id) {
        return petTypeRepository.findById(id);
    }

    @Override
    public void updatePetType(PetType petType) {
        petTypeRepository.saveAndFlush(petType);
    }

    @Override
    public void deletePetTypeById(Long id) {
        findPetTypeById(id).ifPresent(petType -> {
            petType.setActive(false);
            updatePetType(petType);
        });
    }

    @Override
    public void fullDeletePetTypeById(Long id) {
        findPetTypeById(id).ifPresent(petType -> petTypeRepository.delete(petType));
    }

    @Override
    public void restorePetTypeById(Long id) {
        findPetTypeById(id).ifPresent(petType -> {
            petType.setActive(true);
            updatePetType(petType);
        });
    }
}
