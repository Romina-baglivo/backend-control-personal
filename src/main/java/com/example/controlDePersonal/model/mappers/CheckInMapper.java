package com.example.controlDePersonal.model.mappers;

import com.example.controlDePersonal.model.dtos.CheckInDTO;
import com.example.controlDePersonal.model.entities.CheckInEntity;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class CheckInMapper {
    public CheckInDTO toDTO(CheckInEntity entity) {
        if (entity == null) return null;

        return CheckInDTO.builder()
                .dni(entity.getEmployee().getDni())
                .name(entity.getEmployee().getName())
                .lastName(entity.getEmployee().getLastName())
                .dateTime(entity.getDateTime())
                .build();
    }
}
