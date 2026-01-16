package com.example.controlDePersonal.services.interfaces;

import com.example.controlDePersonal.model.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();
    EmployeeDTO create(EmployeeDTO employee);
    void update(String dni, EmployeeDTO employee);
    void delete(String dni);
    EmployeeDTO findBy(String dni);
}
