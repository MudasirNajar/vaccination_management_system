package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.models.VaccinationCenter;
import com.example.vaccineManagementSystem.repositories.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccinationService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {
        Optional<VaccinationCenter> vaccinationCenterOptional
                = vaccinationCenterRepository.findById(vaccinationCenter.getId());

        if (vaccinationCenterOptional.isEmpty()) {
            if (vaccinationCenter.getAddress().isEmpty()) {
                throw new VaccinationAddressNotFound("Vaccination address not found");
            }
            vaccinationCenterRepository.save(vaccinationCenter);
            return "Added Vaccination Center at address" + vaccinationCenter.getAddress();
        }
        return null;
    }
}
