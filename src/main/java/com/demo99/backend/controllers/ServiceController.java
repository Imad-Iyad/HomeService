package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.ServiceReqDTO;
import com.demo99.backend.model.dto.ServiceResDTO;
import com.demo99.backend.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping(path = "/get-all")
    public List<ServiceResDTO> getAllServices(){
        return serviceService.getAllServices();
    }

    @GetMapping(path = "/get/{id}")
    public ServiceResDTO getServiceById(@PathVariable Long id){
        return this.serviceService.getServiceById(id);
    }

    @PostMapping(path = "/creat")
    public ServiceResDTO createService(@RequestBody ServiceReqDTO service) {
        return this.serviceService.createService(service);
    }

    @PutMapping(path = "/update/{id}")
    public ServiceResDTO updateService(@PathVariable Long id, @RequestBody ServiceReqDTO service) {
        return this.serviceService.updateService(id, service);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteService(@PathVariable Long id){
        return this.serviceService.deleteService(id);
    }
}
