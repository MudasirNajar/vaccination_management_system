package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.dtos.requestdtos.AssociateDocDto;
import com.example.vaccineManagementSystem.exceptions.CenterNotFound;
import com.example.vaccineManagementSystem.exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.exceptions.EmailIdEmptyException;
import com.example.vaccineManagementSystem.exceptions.DoctorAlreadyExistsException;
import com.example.vaccineManagementSystem.models.Doctor;
import com.example.vaccineManagementSystem.models.VaccinationCenter;
import com.example.vaccineManagementSystem.repositories.DoctorRepository;
import com.example.vaccineManagementSystem.repositories.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

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

    public String associateDoctor(AssociateDocDto associateDocDto) throws DoctorNotFound,
            CenterNotFound {

        int docId = associateDocDto.getDocId();
        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);
        if (doctorOptional.isEmpty()) {
            throw new DoctorNotFound("Doctor id is wrong");
        }
        int centerId = associateDocDto.getCenterId();
        Optional<VaccinationCenter> vaccinationCenterOptional
                = vaccinationCenterRepository.findById(centerId);

        if (vaccinationCenterOptional.isEmpty()) {
            throw new CenterNotFound("Center Id entered is incorrect");
        }

        Doctor doctor = doctorOptional.get();
        VaccinationCenter center = vaccinationCenterOptional.get();
        doctor.setVaccinationCenter(center); //Setting foreign key in child table
        //Set the bidirectional mapping
        //Adding the doctor to the list of doctors of vaccination center
        center.getDoctorList().add(doctor);

        vaccinationCenterRepository.save(center);
        return "Doctor has been associated to the center";
    }
}
