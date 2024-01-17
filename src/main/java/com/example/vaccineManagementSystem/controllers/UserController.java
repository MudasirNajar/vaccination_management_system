package com.example.vaccineManagementSystem.controllers;

import com.example.vaccineManagementSystem.dtos.requestdtos.UpdateEmailDto;
import com.example.vaccineManagementSystem.services.UserService;
import com.example.vaccineManagementSystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getVaccinationDate")
    public Date getVaccinationDate(@RequestParam("userId") Integer userId) {
        return userService.getVaccinationDate(userId);
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto) {
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/getByEmail/{emailId}")
    public User getByEmail(@PathVariable("emailId") String emailId) {
        return userService.getByEmail(emailId);
    }
}
