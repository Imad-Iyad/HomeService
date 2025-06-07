package com.demo99.backend.services;

import com.demo99.backend.model.entities.Appointment;
import com.demo99.backend.model.entities.Enums.AppointmentStatus;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByCustomer(Long id);
    List<Appointment> getAppointmentsByProvider(Long providerId);
    Appointment updateStatus(Long appointmentId, AppointmentStatus status);
}
