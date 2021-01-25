package com.example.springpetclinic.services;

import com.example.springpetclinic.models.Appointment;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    /**
     * To create a new appointment
     *
     * @param appointment Appointment
     */
    void createAppointment(Appointment appointment);

    /**
     * To get all the appointments
     *
     * @return list of appointments
     */
    List<Appointment> getAllAppointments();

    /**
     * To get list of active appointments
     *
     * @return list of appointments
     */
    List<Appointment> getActiveAppointments();

    /**
     * To find appointment by id
     *
     * @param id Appointment id
     * @return optional of appointment
     */
    Optional<Appointment> findAppointmentById(Long id);

    /**
     * To update an existing appointment
     *
     * @param appointment Appointment
     */
    void updateAppointment(Appointment appointment);

    /**
     * To delete an appointment by id
     *
     * @param id Appointment id
     */
    void deleteAppointmentById(Long id);

    /**
     * To delete an appointment from database completely by id
     *
     * @param id Appointment id
     */
    void fullDeleteAppointmentById(Long id);

    /**
     * To restore an appointment by id
     *
     * @param id Appointment id
     */
    void restoreAppointmentById(Long id);

    List<Appointment> findAppointmentByPetId(Long petId);
}
