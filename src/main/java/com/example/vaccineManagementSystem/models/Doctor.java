package com.example.vaccineManagementSystem.models;

import com.example.vaccineManagementSystem.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    @Column(name = "doctor_name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private int age;

    @Column(unique = true)
    private String emailId;
}
