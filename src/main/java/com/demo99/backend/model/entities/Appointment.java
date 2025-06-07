package com.demo99.backend.model.entities;

import com.demo99.backend.model.entities.Enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User Customer;

    @ManyToOne
    private User provider;

    @ManyToOne
    private Service service;

    private LocalDate date;

    private LocalTime startTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
