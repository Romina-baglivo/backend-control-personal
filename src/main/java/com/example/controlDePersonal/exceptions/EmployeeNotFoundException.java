package com.example.controlDePersonal.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String dni) {

        super("Empleado con DNI " + dni + " no encontrado.");
    }
}

