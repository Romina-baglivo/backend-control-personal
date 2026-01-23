package com.example.controlDePersonal.services.interfaces;

import com.example.controlDePersonal.model.dtos.CheckOutDTO;
import java.time.LocalDate;
import java.util.List;



public interface CheckOutService {

    CheckOutDTO checkOut(String dni);
    List<CheckOutDTO> getCheckOutsByDate(LocalDate date);
}
