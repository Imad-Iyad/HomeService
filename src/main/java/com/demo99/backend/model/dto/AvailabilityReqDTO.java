package com.demo99.backend.model.dto;

import com.demo99.backend.model.entities.Enums.DayOfWeekEnum;
import com.demo99.backend.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityReqDTO {

    private User provider;

    private DayOfWeekEnum dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;
}
