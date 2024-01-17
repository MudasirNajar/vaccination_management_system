package com.example.vaccineManagementSystem.models;

import com.example.vaccineManagementSystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name") //This will create a custom column name in the table
    private String name;

    private int age;

    @Column(unique = true)  //If duplicate emailId is passed MySQL will throw new Exception()
    private String emailId;

    @Enumerated(value = EnumType.STRING)  //MySQL only understands the usual primitive data types
    //so storing gender as a string
    private Gender gender;
    private String mobileNo;

//    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose dose;

    public Dose getDose() {
        return dose;
    }

    public void setDose(Dose dose) {
        this.dose = dose;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
