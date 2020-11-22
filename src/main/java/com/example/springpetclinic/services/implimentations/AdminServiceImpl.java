package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Admin;
import com.example.springpetclinic.repositories.AdminRepository;
import com.example.springpetclinic.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void createAdmin(Admin admin) {
        admin.setActive(true);
        adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Admin> getActiveAdmins() {
        return getAllAdmins().stream()
                .filter(Admin::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Admin> findByFirstnameAndLastname(String firstName, String lastName) {
        return adminRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Admin> findAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        findAdminById(id).ifPresent(admin -> {
            admin.setActive(false);
            updateAdmin(admin);
        });
    }

    @Override
    public void fullDeleteAdminById(Long id) {
        findAdminById(id).ifPresent(admin -> adminRepository.delete(admin));
    }

    @Override
    public void restoreAdminById(Long id) {
        findAdminById(id).ifPresent(admin -> {
            admin.setActive(true);
            updateAdmin(admin);
        });
    }
}
