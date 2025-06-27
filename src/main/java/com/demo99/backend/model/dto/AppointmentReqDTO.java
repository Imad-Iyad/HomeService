package com.demo99.backend.model.dto;

import com.demo99.backend.model.entities.Enums.AppointmentStatus;
import com.demo99.backend.model.entities.Service;
import com.demo99.backend.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentReqDTO {
    private User customer;

    private User provider;

    private Service service;

    private LocalDate date;

    private LocalTime startTime;

    private AppointmentStatus status;
}
