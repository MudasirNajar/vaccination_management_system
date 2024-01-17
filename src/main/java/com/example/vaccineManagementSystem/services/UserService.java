package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.dtos.requestdtos.UpdateEmailDto;
import com.example.vaccineManagementSystem.models.Dose;
import com.example.vaccineManagementSystem.models.User;
import com.example.vaccineManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Date getVaccinationDate(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            Dose dose = user.getDose();
            return dose.getVaccinationDate();
        }
        return null;
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId = updateEmailDto.getUserId();
        User user = userRepository.findById(userId).get();

        //Modify the entity with new parameters
        user.setEmailId(updateEmailDto.getNewEmailId());
        userRepository.save(user);
        return "Old email has been modified with the new one " + updateEmailDto.getNewEmailId();
    }

    public User getByEmail(String email) {
        return userRepository.findByEmailId(email);
    }
}
