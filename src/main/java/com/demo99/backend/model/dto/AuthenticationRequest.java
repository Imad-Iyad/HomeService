package com.demo99.backend.model.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}