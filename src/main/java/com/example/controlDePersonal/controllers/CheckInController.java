package com.example.controlDePersonal.controllers;
import com.example.controlDePersonal.model.dtos.CheckInDTO;
import com.example.controlDePersonal.services.interfaces.CheckInService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/check-in")
@RequiredArgsConstructor
public class CheckInController {

    private final CheckInService checkInService;

    @PostMapping("/{dni}")
    public CheckInDTO checkIn(@PathVariable String dni) {
        if (StringUtils.isBlank(dni)) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }

        return this.checkInService.checkIn(dni);
    }
}









