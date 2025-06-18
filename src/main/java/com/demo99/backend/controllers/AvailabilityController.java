package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.AvailabilityReqDTO;
import com.demo99.backend.model.dto.AvailabilityResDTO;
import com.demo99.backend.services.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/Availabilities")
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    @GetMapping(path = "/{id}")
    public List<AvailabilityResDTO> getAvailabilityByProvider(@PathVariable Long id){
        return this.availabilityService.getAvailabilityByProvider(id);
    }

    @PostMapping
    public AvailabilityResDTO createAvailability(@RequestBody AvailabilityReqDTO availability){
        return this.availabilityService.createAvailability(availability);
    }

    @PutMapping(path = "/{id}")
    public AvailabilityResDTO updateAvailability(@PathVariable Long id, @RequestBody AvailabilityReqDTO availability){
        return this.availabilityService.updateAvailability(id, availability);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAvailability(@PathVariable Long id){
        return this.availabilityService.deleteAvailability(id);
    }
}
