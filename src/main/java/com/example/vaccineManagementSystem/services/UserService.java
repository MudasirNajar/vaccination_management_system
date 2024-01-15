package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.models.User;
import com.example.vaccineManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
