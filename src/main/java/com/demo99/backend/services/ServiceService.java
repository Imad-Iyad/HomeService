package com.demo99.backend.services;

import com.demo99.backend.model.dto.ServiceReqDTO;
import com.demo99.backend.model.dto.ServiceResDTO;

import java.util.List;

public interface ServiceService {
    List<ServiceResDTO> getAllServices();
    ServiceResDTO getServiceById(Long id);
    ServiceResDTO createService(ServiceReqDTO service);
    ServiceResDTO updateService(Long id, ServiceReqDTO service);
    String deleteService(Long id);
}
