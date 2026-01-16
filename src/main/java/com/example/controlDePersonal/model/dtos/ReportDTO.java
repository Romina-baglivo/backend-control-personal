package com.example.controlDePersonal.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private String dni;
    private String name;
    private String lastName;
    private int absences;
    private int lateArrivals;
    private int earlyLeaves;

}

