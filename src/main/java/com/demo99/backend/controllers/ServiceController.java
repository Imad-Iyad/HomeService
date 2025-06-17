package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.ServiceResDTO;
import com.demo99.backend.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping
    public List<ServiceResDTO> getAllServices(){
        return serviceService.getAllServices();
    }

    @GetMapping(path = "/{id}")
    public ServiceResDTO getServiceById(@PathVariable Long id){
        return this.serviceService.getServiceById(id);
    }
}
