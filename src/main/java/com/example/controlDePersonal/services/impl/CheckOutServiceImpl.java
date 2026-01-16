package com.example.controlDePersonal.services.impl;

import com.example.controlDePersonal.model.dtos.CheckOutDTO;
import com.example.controlDePersonal.model.entities.CheckOutEntity;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import com.example.controlDePersonal.model.mappers.CheckOutMapper;
import com.example.controlDePersonal.repositories.CheckOutRepository;
import com.example.controlDePersonal.repositories.EmployeeRepository;
import com.example.controlDePersonal.services.interfaces.CheckOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckOutServiceImpl implements CheckOutService {
    private final CheckOutRepository checkOutRepository;
    private final EmployeeRepository employeeRepository;
    private final CheckOutMapper checkOutMapper;

    @Override
    public CheckOutDTO checkOut(String dni) {
        EmployeeEntity employee = employeeRepository.findById(dni)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con DNI: " + dni));

        CheckOutEntity checkOut = CheckOutEntity.builder()
                .employee(employee)
                .dateTime(LocalDateTime.now())
                .build();

        checkOutRepository.save(checkOut);

        return checkOutMapper.toDTO(checkOut);
    }

    @Override
    public List<CheckOutDTO> getCheckOutsByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        return checkOutRepository.findByDateTimeBetween(startOfDay, endOfDay)
                .stream()
                .map(checkOutMapper::toDTO)
                .collect(Collectors.toList());
    }

}
