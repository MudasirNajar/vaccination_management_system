package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.exceptions.EmailIdEmptyException;
import com.example.vaccineManagementSystem.exceptions.DoctorAlreadyExistsException;
import com.example.vaccineManagementSystem.models.Doctor;
import com.example.vaccineManagementSystem.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {


    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmptyException, DoctorAlreadyExistsException {
        //Validations
        if (doctor.getEmailId().isEmpty()) {
            throw new EmailIdEmptyException("Email id is mandatory");
        }
        if (doctorRepository.findByEmailId(doctor.getEmailId()) != null) {
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exists");
        }

        doctorRepository.save(doctor);
        return "Doctor added successfully";
    }
}
