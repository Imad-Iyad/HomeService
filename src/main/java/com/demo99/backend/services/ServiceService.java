package com.demo99.backend.services;

import com.demo99.backend.model.dto.ServiceReqDTO;
import com.demo99.backend.model.dto.ServiceResDTO;
import com.demo99.backend.model.entities.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getAllServices();
    Service getServiceById(Long id);
    ServiceResDTO createService(ServiceReqDTO service);
    Service updateService(Long id, Service service);
    void deleteService(Long id);
}
