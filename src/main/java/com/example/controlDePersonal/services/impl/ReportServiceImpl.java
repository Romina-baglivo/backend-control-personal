package com.example.controlDePersonal.services.impl;

import com.example.controlDePersonal.model.dtos.ReportDTO;
import com.example.controlDePersonal.model.entities.CheckInEntity;
import com.example.controlDePersonal.model.entities.CheckOutEntity;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import com.example.controlDePersonal.model.mappers.ReportMapper;
import com.example.controlDePersonal.repositories.CheckInRepository;
import com.example.controlDePersonal.repositories.CheckOutRepository;
import com.example.controlDePersonal.repositories.EmployeeRepository;
import com.example.controlDePersonal.services.interfaces.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EmployeeRepository employeeRepository;
    private final CheckInRepository checkInRepository;
    private final CheckOutRepository checkOutRepository;
    private final ReportMapper reportMapper;

    @Value("${report.late-arrival-time}")
    private String lateArrivalTimeStr;

    @Value("${report.early-leave-time}")
    private String earlyLeaveTimeStr;

    @Override
    public List<ReportDTO> getMonthlyReport(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        LocalTime lateArrivalTime = LocalTime.parse(lateArrivalTimeStr);
        LocalTime earlyLeaveTime = LocalTime.parse(earlyLeaveTimeStr);

        List<EmployeeEntity> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> {
            // Filtrar registros de check-in de este empleado
            List<CheckInEntity> employeeCheckIns = checkInRepository.findByDateTimeBetween(startDateTime, endDateTime)
                    .stream()
                    .filter(checkIn -> checkIn.getEmployee() != null &&
                            checkIn.getEmployee().getDni().equals(employee.getDni()))
                    .toList();

            // Filtrar registros de check-out de este empleado
            List<CheckOutEntity> employeeCheckOuts = checkOutRepository.findByDateTimeBetween(startDateTime, endDateTime)
                    .stream()
                    .filter(checkOut -> checkOut.getEmployee() != null &&
                            checkOut.getEmployee().getDni().equals(employee.getDni()))
                    .toList();

            int totalDaysInMonth = yearMonth.lengthOfMonth();

            int totalAbsences = totalDaysInMonth - employeeCheckIns.size();

            int totalLateArrivals = (int) employeeCheckIns.stream()
                    .filter(checkIn -> checkIn.getDateTime().toLocalTime().isAfter(lateArrivalTime))
                    .count();

            int totalEarlyLeaves = (int) employeeCheckOuts.stream()
                    .filter(checkOut -> checkOut.getDateTime().toLocalTime().isBefore(earlyLeaveTime))
                    .count();

            return reportMapper.toDTO(employee, totalAbsences, totalLateArrivals, totalEarlyLeaves);
        }).collect(Collectors.toList());
    }
}
