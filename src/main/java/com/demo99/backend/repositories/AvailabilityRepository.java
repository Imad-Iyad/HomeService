package com.demo99.backend.repositories;

import com.demo99.backend.model.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability,Long> {
    List<Availability> findByProviderId(Long providerId);
}

