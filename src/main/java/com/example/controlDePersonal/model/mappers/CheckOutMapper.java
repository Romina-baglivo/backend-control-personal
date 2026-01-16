package com.example.controlDePersonal.model.mappers;

import com.example.controlDePersonal.model.dtos.CheckOutDTO;
import com.example.controlDePersonal.model.entities.CheckOutEntity;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class CheckOutMapper {
    public CheckOutDTO toDTO(CheckOutEntity entity) {
        if (entity == null) return null;

        return CheckOutDTO.builder()
                .dni(entity.getEmployee().getDni())
                .name(entity.getEmployee().getName())
                .lastName(entity.getEmployee().getLastName())
                .dateTime(entity.getDateTime())
                .build();
    }
}
