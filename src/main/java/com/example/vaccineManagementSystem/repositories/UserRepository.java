package com.example.vaccineManagementSystem.repositories;

import com.example.vaccineManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
