package com.demo99.backend.services;

import com.demo99.backend.model.dto.AvailabilityReqDTO;
import com.demo99.backend.model.dto.AvailabilityResDTO;

import java.util.List;

public interface AvailabilityService {
    List<AvailabilityResDTO> getAvailabilityByProvider(Long providerId);
    AvailabilityResDTO createAvailability(AvailabilityReqDTO availability);
    AvailabilityResDTO updateAvailability(Long id, AvailabilityReqDTO availability);
    String deleteAvailability(Long id);

}
