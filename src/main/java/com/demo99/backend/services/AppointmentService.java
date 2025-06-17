package com.demo99.backend.services;

import com.demo99.backend.model.dto.AppointmentReqDTO;
import com.demo99.backend.model.dto.AppointmentResDTO;
import com.demo99.backend.model.entities.Appointment;
import com.demo99.backend.model.entities.Enums.AppointmentStatus;

import java.util.List;

public interface AppointmentService {
    AppointmentResDTO bookAppointment(AppointmentReqDTO appointment);
    List<Appointment> getAppointmentsByCustomer(Long id);
    List<Appointment> getAppointmentsByProvider(Long providerId);
    AppointmentResDTO updateStatus(Long appointmentId, AppointmentStatus status);
}
