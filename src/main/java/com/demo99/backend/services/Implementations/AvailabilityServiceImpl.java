package com.demo99.backend.services.Implementations;

import com.demo99.backend.exceptions.ResourceNotFoundException;
import com.demo99.backend.model.dto.AvailabilityReqDTO;
import com.demo99.backend.model.dto.AvailabilityResDTO;
import com.demo99.backend.model.entities.Availability;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.model.mapper.Impl.AvailabilityMapper;
import com.demo99.backend.repositories.AvailabilityRepository;
import com.demo99.backend.repositories.UserRepository;
import com.demo99.backend.services.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final UserRepository userRepository;
    private final AvailabilityMapper availabilityMapper;

    @Override
    public List<AvailabilityResDTO> getAvailabilityByProvider(Long providerId){
        Optional<User> potUser = userRepository.findById(providerId);
        if (potUser.isPresent()){
            return this.availabilityMapper.toListDto(availabilityRepository.findByProviderId(providerId));
        }else {
            throw new ResourceNotFoundException("Provider not found");
        }
    }
    @Override
    public AvailabilityResDTO createAvailability(AvailabilityReqDTO availability){
        Availability availabilityEntity = availabilityMapper.toEntity(availability);
        return this.availabilityMapper.toDto(availabilityRepository.save(availabilityEntity));
    }

    @Override
    public AvailabilityResDTO updateAvailability(Long id, AvailabilityReqDTO availabilityDto){
        Availability availabilityEntity = availabilityMapper.toEntity(availabilityDto);
        Optional<Availability> availabilityOptional = availabilityRepository.findById(id);
        if (availabilityOptional.isPresent()){
            Availability availabilityToUpdate = availabilityOptional.get();
            availabilityToUpdate.setDayOfWeek(availabilityEntity.getDayOfWeek());
            availabilityToUpdate.setStartTime(availabilityEntity.getStartTime());
            availabilityToUpdate.setEndTime(availabilityEntity.getEndTime());
            return this.availabilityMapper.toDto(availabilityRepository.save(availabilityToUpdate));
        }
        throw new ResourceNotFoundException("Availability not found");
    }

    @Override
    public String deleteAvailability(Long id){
        Optional<Availability> availabilityOptional = availabilityRepository.findById(id);
        if (availabilityOptional.isPresent()){
            availabilityRepository.deleteById(id);
            return "availability deleted";
        }else {
            throw new ResourceNotFoundException("Availability not found");
        }
    }
}
