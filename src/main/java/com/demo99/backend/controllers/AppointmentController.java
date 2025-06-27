package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.AppointmentReqDTO;
import com.demo99.backend.model.dto.AppointmentResDTO;
import com.demo99.backend.model.entities.Enums.AppointmentStatus;
import com.demo99.backend.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping(path = "book")
    public AppointmentResDTO bookAppointment(@RequestBody AppointmentReqDTO appointmentReqDTO){
        return this.appointmentService.bookAppointment(appointmentReqDTO);
    }

    @GetMapping(path = "by-customer/{id}")
    public List<AppointmentResDTO> getAppointmentsByCustomer(@PathVariable Long id){
        return this.appointmentService.getAppointmentsByCustomer(id);
    }

    @GetMapping(path = "/by-provider/{id}")
    public List<AppointmentResDTO> getAppointmentsByProvider(@PathVariable Long id){
        return this.appointmentService.getAppointmentsByProvider(id);
    }

    @PutMapping(path = "update-status/{id}")
    public AppointmentResDTO updateAppointment(@PathVariable Long id, @RequestBody AppointmentStatus appointmentStatus){
        return this.appointmentService.updateStatus(id,appointmentStatus);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAppointment(@PathVariable Long id){}

}
