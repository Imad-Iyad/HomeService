package com.demo99.backend.services.Implementations;

import com.demo99.backend.exceptions.ResourceNotFoundException;
import com.demo99.backend.model.dto.AppointmentReqDTO;
import com.demo99.backend.model.dto.AppointmentResDTO;
import com.demo99.backend.model.entities.Appointment;
import com.demo99.backend.model.entities.Enums.AppointmentStatus;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.model.mapper.Impl.AppointmentMapper;
import com.demo99.backend.repositories.AppointmentRepository;
import com.demo99.backend.repositories.UserRepository;
import com.demo99.backend.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Override
    public AppointmentResDTO bookAppointment(AppointmentReqDTO appointment){
        Appointment entity = this.appointmentMapper.toEntity(appointment);
        return this.appointmentMapper.toDTO(this.appointmentRepository.save(entity));
    }

    @Override
    public List<AppointmentResDTO> getAppointmentsByCustomer(Long customerId) {
        Optional<User> entity = this.userRepository.findById(customerId);
        if (entity.isPresent()) {
            return this.appointmentMapper.toListDTO(this.appointmentRepository.findByCustomerId(customerId));
        }else{
            throw new ResourceNotFoundException("Customer not found");
        }
    }

    @Override
    public List<AppointmentResDTO> getAppointmentsByProvider(Long providerId) {
        Optional<User> entity = this.userRepository.findById(providerId);
        if (entity.isPresent()) {
            return this.appointmentMapper.toListDTO(this.appointmentRepository.findByProviderId(providerId));
        }else{
            throw new ResourceNotFoundException("Provider not found");
        }
    }

    @Override
    public AppointmentResDTO updateStatus(Long appointmentId, AppointmentStatus status) {
        Optional<Appointment> entity = this.appointmentRepository.findById(appointmentId);
        if (entity.isPresent()) {
            entity.get().setStatus(status);
            return this.appointmentMapper.toDTO(this.appointmentRepository.save(entity.get()));
        }else {
            throw new ResourceNotFoundException("Appointment not found");
        }
    }

}