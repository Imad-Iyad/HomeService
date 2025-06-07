package com.demo99.backend.services;

import com.demo99.backend.model.entities.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getAllServices();
    Service getServiceById(Long id);
    Service createService(Service service);
    Service updateService(Long id, Service service);
    void deleteService(Long id);
}
