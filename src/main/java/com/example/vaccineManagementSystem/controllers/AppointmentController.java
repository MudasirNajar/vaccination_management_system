package com.example.vaccineManagementSystem.controllers;

import com.example.vaccineManagementSystem.dtos.requestdtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.exceptions.UserNotFound;
import com.example.vaccineManagementSystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto) {
        try {
            return appointmentService.bookAppointment(appointmentReqDto);
        } catch (UserNotFound | DoctorNotFound e) {
            return e.getMessage();
        }
    }
}
