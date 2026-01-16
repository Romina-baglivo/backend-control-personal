package com.example.controlDePersonal.repositories;

import com.example.controlDePersonal.model.entities.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface CheckInRepository extends JpaRepository<CheckInEntity, Long>{

    //Metodo que busca registros por fecha, inicio y fin
    List<CheckInEntity>findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    void deleteAllByEmployeeDni(String dni);
}
