package com.example.controlDePersonal.model.mappers;

import com.example.controlDePersonal.model.dtos.ReportDTO;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDTO toDTO(EmployeeEntity employee, int absences, int lateArrivals, int earlyLeaves) {
        if (employee == null) return null;

        return ReportDTO.builder()
                .dni(employee.getDni())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .absences(absences)
                .lateArrivals(lateArrivals)
                .earlyLeaves(earlyLeaves)
                .build();
    }

}
