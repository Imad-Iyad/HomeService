package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.AppointmentReqDTO;
import com.demo99.backend.model.dto.AppointmentResDTO;
import com.demo99.backend.model.entities.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toEntity(AppointmentReqDTO dto);
    AppointmentResDTO toDTO(Appointment entity);
    List<AppointmentResDTO> toListDTO(List<Appointment> entityList);
}
