package com.demo99.backend.services;

import com.demo99.backend.model.entities.Availability;

import java.util.List;

public interface AvailabilityService {
    List<Availability> getAvailabilityByProvider(Long providerId);
    Availability createAvailability(Availability availability);
    Availability updateAvailability(Long id, Availability availability);
    void deleteAvailability(Long id);

}
