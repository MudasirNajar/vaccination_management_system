package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.models.Dose;
import com.example.vaccineManagementSystem.models.User;
import com.example.vaccineManagementSystem.repositories.DoseRepository;
import com.example.vaccineManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId, Integer userId) {

        if (userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            Dose dose = new Dose();
            dose.setDoseId(doseId);
            dose.setUser(user);

            //Setting the child object for parent as an attribute
            user.setDose(dose);

            userRepository.save(user);

            //Child will automatically get saved because of Cascading effect
            return "Dose given to user successfully";
        }
        return "null";
    }
}
