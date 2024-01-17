package com.example.vaccineManagementSystem.repositories;

import com.example.vaccineManagementSystem.models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
