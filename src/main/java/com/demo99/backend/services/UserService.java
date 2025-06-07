package com.demo99.backend.services;

import com.demo99.backend.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById (Long id);
    List<User> getAllProviders();
    String UpdateUser(Long id, User user);
    String deleteUser(Long id);
}
