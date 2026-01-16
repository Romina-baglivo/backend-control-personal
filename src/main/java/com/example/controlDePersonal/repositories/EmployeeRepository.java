package com.example.controlDePersonal.repositories;

import com.example.controlDePersonal.model.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {



}
