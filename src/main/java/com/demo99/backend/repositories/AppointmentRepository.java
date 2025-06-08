package com.demo99.backend.repositories;

import com.demo99.backend.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    /*List<Appointment> findByProviderId(Long providerId);
    List<Appointment> findByCustomerId(Long customerId);*/
}
