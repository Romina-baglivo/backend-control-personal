package com.example.controlDePersonal.controllers;

import com.example.controlDePersonal.model.dtos.CheckOutDTO;
import com.example.controlDePersonal.services.interfaces.CheckOutService;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/check-out")
@RequiredArgsConstructor
public class CheckOutController {

    private final CheckOutService checkOutService;

    @PostMapping("/{dni}")
    public CheckOutDTO checkOut(@PathVariable String dni) {
        if (StringUtils.isBlank(dni)) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        return  this.checkOutService.checkOut(dni);
    }


}
