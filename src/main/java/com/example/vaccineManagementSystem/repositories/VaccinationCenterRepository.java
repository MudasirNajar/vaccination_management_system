package com.example.vaccineManagementSystem.repositories;

import com.example.vaccineManagementSystem.models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
