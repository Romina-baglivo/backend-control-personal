package com.example.controlDePersonal.controllers;

import com.example.controlDePersonal.model.dtos.ReportDTO;
import com.example.controlDePersonal.services.interfaces.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/monthly")
    public List<ReportDTO> getMonthlyReport(@RequestParam int month,
                                            @RequestParam int year) {
        return this.reportService.getMonthlyReport(month, year);
    }


}
