package com.example.vaccineManagementSystem.controllers;

import com.example.vaccineManagementSystem.dtos.requestdtos.AssociateDocDto;
import com.example.vaccineManagementSystem.exceptions.CenterNotFound;
import com.example.vaccineManagementSystem.exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.models.Doctor;
import com.example.vaccineManagementSystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {
        try {
            return doctorService.addDoctor(doctor);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/associateWithCenter")
    public ResponseEntity<String> associateDoctor(AssociateDocDto associateDocDto) {

        try {
            String response = doctorService.associateDoctor(associateDocDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DoctorNotFound | CenterNotFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
