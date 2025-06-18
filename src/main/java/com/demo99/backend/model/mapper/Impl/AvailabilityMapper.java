package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.AvailabilityReqDTO;
import com.demo99.backend.model.dto.AvailabilityResDTO;
import com.demo99.backend.model.entities.Availability;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    Availability toEntity(AvailabilityReqDTO dto);
    AvailabilityResDTO toDto(Availability availability);
    List<AvailabilityResDTO> toListDto(List<Availability> availabilities);
}
