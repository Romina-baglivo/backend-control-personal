package com.example.controlDePersonal.services.interfaces;

import com.example.controlDePersonal.model.dtos.ReportDTO;

import java.util.List;

public interface ReportService {

    List<ReportDTO> getMonthlyReport(int month, int year);
}

