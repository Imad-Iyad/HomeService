package com.demo99.backend.services.Implementations;

import com.demo99.backend.model.dto.ServiceReqDTO;
import com.demo99.backend.model.dto.ServiceResDTO;
import com.demo99.backend.model.entities.Service;
import com.demo99.backend.model.mapper.Impl.ServiceMapper;
import com.demo99.backend.repositories.ServiceRepository;
import com.demo99.backend.services.ServiceService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }

    @Override
    public Service getServiceById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.orElse(null);
    }

    @Override
    public ServiceResDTO createService(ServiceReqDTO service) {
        Service serviceEntity = serviceMapper.toEntity(service);
        return serviceMapper.toDTO(serviceRepository.save(serviceEntity));
    }

    @Override
    public Service updateService(Long id, ServiceReqDTO service) {
        Service ServiceEntity = serviceMapper.toEntity(service);
        Optional<Service> optionalServiceEntity = serviceRepository.findById(id);
        if (optionalServiceEntity.isPresent()) {
            optionalServiceEntity.get().setName(service.getName());
            optionalServiceEntity.get().setDescription(service.getDescription());
            optionalServiceEntity.get().setCategory(service.getCategory());
            return serviceRepository.save(optionalServiceEntity.get());
        }else {
            return null;
        }
    }

    @Override
    public String deleteService(Long id) {
        Optional<Service> optionalServiceEntity = serviceRepository.findById(id);
        if (optionalServiceEntity.isPresent()) {
            serviceRepository.delete(optionalServiceEntity.get());
            return optionalServiceEntity.get().getName() + "Deleted";
        }
        return "Service not found";
    }
}
