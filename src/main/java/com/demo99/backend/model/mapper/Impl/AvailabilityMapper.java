package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.AvailabilityReqDTO;
import com.demo99.backend.model.entities.Availability;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    Availability toEntity(AvailabilityReqDTO dto);
    AvailabilityReqDTO toDto(Availability availability);
}
