package com.example.controlDePersonal.services.interfaces;

import com.example.controlDePersonal.model.dtos.CheckInDTO;
import com.example.controlDePersonal.model.dtos.CheckOutDTO;
import com.example.controlDePersonal.model.entities.CheckOutEntity;
import com.example.controlDePersonal.repositories.CheckOutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public interface CheckOutService {

    CheckOutDTO checkOut(String dni);
    List<CheckOutDTO> getCheckOutsByDate(LocalDate date);
}
