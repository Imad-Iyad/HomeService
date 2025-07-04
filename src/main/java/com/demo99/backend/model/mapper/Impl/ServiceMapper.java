package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.ServiceReqDTO;
import com.demo99.backend.model.dto.ServiceResDTO;
import com.demo99.backend.model.entities.Service;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    Service toEntity(ServiceReqDTO service);
    ServiceResDTO toDTO(Service service);
    List<ServiceResDTO> toListDTO(List<Service> services);
}
