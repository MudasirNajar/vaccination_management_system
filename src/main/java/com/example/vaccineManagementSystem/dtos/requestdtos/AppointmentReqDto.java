package com.example.vaccineManagementSystem.dtos.requestdtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentReqDto {

    private int userId;
    private int docId;
    private Date appointmentDate;
    private LocalTime appointmentTime;

}
