package com.demo99.backend.services.Implementations;

import com.demo99.backend.model.entities.Availability;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.repositories.AvailabilityRepository;
import com.demo99.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl {

    private final AvailabilityRepository availabilityRepository;
    private final UserRepository userRepository;

    public List<Availability> getAvailabilityByProvider(Long providerId){
        Optional<User> potUser = userRepository.findById(providerId);
        if (potUser.isPresent()){
            return availabilityRepository.findByProviderId(providerId);
        }else {
            return null;
        }
    }

    public Availability createAvailability(Availability availability){
        return availabilityRepository.save(availability);
    }

    public Availability updateAvailability(Long id, Availability availability){
        Optional<Availability> availabilityOptional = availabilityRepository.findById(id);
        if (availabilityOptional.isPresent()){
            Availability availabilityToUpdate = availabilityOptional.get();
            availabilityToUpdate.setDayOfWeek(availability.getDayOfWeek());
            availabilityToUpdate.setStartTime(availability.getStartTime());
            availabilityToUpdate.setEndTime(availability.getEndTime());
            return availabilityRepository.save(availabilityToUpdate);
        }
        return null;
    }

    public void deleteAvailability(Long id){
        availabilityRepository.deleteById(id);
    }
}
