package com.example.controlDePersonal.services.interfaces;

import com.example.controlDePersonal.model.dtos.CheckInDTO;


import java.time.LocalDate;

import java.util.List;


public interface CheckInService {

    CheckInDTO checkIn(String dni);
    List<CheckInDTO> getCheckInsByDate(LocalDate date);
}

