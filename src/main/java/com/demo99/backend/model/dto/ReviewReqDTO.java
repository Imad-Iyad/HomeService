package com.demo99.backend.model.dto;

import com.demo99.backend.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewReqDTO {

    private User customer;

    private User provider;

    private int rating; // 1 to 5

    private String comment;

    private LocalDateTime date;
}
