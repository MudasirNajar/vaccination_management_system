package com.example.vaccineManagementSystem.services;

import com.example.vaccineManagementSystem.dtos.requestdtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.exceptions.UserNotFound;
import com.example.vaccineManagementSystem.models.Appointment;
import com.example.vaccineManagementSystem.models.Doctor;
import com.example.vaccineManagementSystem.models.User;
import com.example.vaccineManagementSystem.repositories.AppointmentRepository;
import com.example.vaccineManagementSystem.repositories.DoctorRepository;
import com.example.vaccineManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    public String bookAppointment(AppointmentReqDto appointmentReqDto) throws UserNotFound,
            DoctorNotFound {

        int userId = appointmentReqDto.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFound("UserId not found");
        }
        int docId = appointmentReqDto.getDocId();
        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);
        if (doctorOptional.isEmpty()) {
            throw new DoctorNotFound("DoctorId not found");
        }

        Date appointmentDate = appointmentReqDto.getAppointmentDate();
        LocalTime appointmentTime = appointmentReqDto.getAppointmentTime();

        User user = userOptional.get();
        Doctor doctor = doctorOptional.get();
        Appointment appointment = new Appointment();

//Creating the obj and setting its attributes

        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        //Setting the foreign key attributes
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        //Appointment needs to be saved so that an appointmentId gets generated & same is mapped with
        //both the parent tables(user & doctor)

        //Method 1 is very prevalent
        //Saving the appointment first to generate the primary key for an appointment
        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);

        //Method 2: get the appointmentId from last saved appointment in appointment list
//        List<Appointment> appointmentList = doctor.getAppointmentList();
//        Appointment latestApp = appointmentList.get(appointmentList.size() - 1);
//        int id = latestApp.getId();
//        appointment.setId(id);


        user.getAppointmentList().add(appointment);


        userRepository.save(user);
        doctorRepository.save(doctor);

        return "Appointment booked successfully";
    }
}
