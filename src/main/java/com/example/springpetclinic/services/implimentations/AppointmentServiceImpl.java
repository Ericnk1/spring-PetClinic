package com.example.springpetclinic.services.implimentations;

import com.example.springpetclinic.models.Appointment;
import com.example.springpetclinic.repositories.AppointmentRepository;
import com.example.springpetclinic.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(Appointment appointment) {
        appointment.setActive(true);
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getActiveAppointments() {
        return getAllAppointments().stream()
                .filter(Appointment::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointment> findAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        findAppointmentById(id).ifPresent(appointment -> {
            appointment.setActive(false);
            updateAppointment(appointment);
        });
    }

    @Override
    public void fullDeleteAppointmentById(Long id) {
        findAppointmentById(id).ifPresent(appointment -> appointmentRepository.delete(appointment));
    }

    @Override
    public void restoreAppointmentById(Long id) {
        findAppointmentById(id).ifPresent(appointment -> {
            appointment.setActive(true);
            updateAppointment(appointment);
        });
    }
}
