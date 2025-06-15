package com.demo99.backend.model.dto;

import com.demo99.backend.model.entities.Enums.AppointmentStatus;
import com.demo99.backend.model.entities.Service;
import com.demo99.backend.model.entities.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentReqDTO {
    private User customer;

    private User provider;

    private Service service;

    private LocalDate date;

    private LocalTime startTime;

    private AppointmentStatus status;
}
