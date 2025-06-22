package com.demo99.backend.model.dto;

import com.demo99.backend.model.entities.Enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role; // CUSTOMER or PROVIDER
}