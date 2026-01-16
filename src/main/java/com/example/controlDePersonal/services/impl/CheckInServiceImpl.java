package com.example.controlDePersonal.services.impl;

import com.example.controlDePersonal.model.dtos.CheckInDTO;
import com.example.controlDePersonal.model.entities.CheckInEntity;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import com.example.controlDePersonal.model.mappers.CheckInMapper;
import com.example.controlDePersonal.repositories.CheckInRepository;
import com.example.controlDePersonal.repositories.EmployeeRepository;
import com.example.controlDePersonal.services.interfaces.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CheckInServiceImpl implements CheckInService {

    private final CheckInRepository checkInRepository;
    private final EmployeeRepository employeeRepository;
    private final CheckInMapper checkInMapper;

    @Override
    public CheckInDTO checkIn(String dni) {
        EmployeeEntity employee = employeeRepository.findById(dni)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        CheckInEntity checkIn = CheckInEntity.builder()
                .employee(employee)
                .dateTime(LocalDateTime.now())
                .build();

        checkInRepository.save(checkIn);
        return this.checkInMapper.toDTO(checkIn);
    }

    @Override
    public List<CheckInDTO> getCheckInsByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);

        return this.checkInRepository.findByDateTimeBetween(start, end)
                .stream()
                .map(checkInMapper::toDTO)
                .collect(Collectors.toList());
    }
}
