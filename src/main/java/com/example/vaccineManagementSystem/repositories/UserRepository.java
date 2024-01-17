package com.example.vaccineManagementSystem.repositories;

import com.example.vaccineManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmailId(String emailId);
    //Just define the function to execute

//    public User findByEmailId(String emailId);
    //Prebuilt functions: and you can use it directly...
    //The important thing is you have to define the inbuilt functions by adding custom details
}
