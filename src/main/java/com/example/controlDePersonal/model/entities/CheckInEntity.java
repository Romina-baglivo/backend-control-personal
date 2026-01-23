package com.example.controlDePersonal.model.entities;
import  lombok.*;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "checkins")
public class CheckInEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_dni", referencedColumnName = "dni", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeeEntity employee;

    @Column(nullable = false)
    private LocalDateTime dateTime;


}

