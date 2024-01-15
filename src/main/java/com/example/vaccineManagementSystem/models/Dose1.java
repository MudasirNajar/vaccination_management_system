package com.example.vaccineManagementSystem.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "dose1")
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  //Primary key

    @Column(unique = true)
    private String doseId;  //Unique

    @CreationTimestamp  //Hibernate will automatically put the timestamp when data is entered in DB
    private Date vaccinationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}
