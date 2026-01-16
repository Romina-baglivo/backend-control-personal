package com.example.controlDePersonal.model.mappers;

import com.example.controlDePersonal.model.dtos.EmployeeDTO;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(EmployeeEntity entity){
        if (entity == null) return null;

        return EmployeeDTO.builder()
                .dni(entity.getDni())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .build();
    }


    public EmployeeEntity toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        return EmployeeEntity.builder()
                .dni(dto.getDni())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .build();
    }

    public void updateEntity(EmployeeDTO dto, EmployeeEntity entity) {
        if (dto == null || entity == null) return;

        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAddress(dto.getAddress());
    }

}
