package com.example.controlDePersonal.controllers;

import com.example.controlDePersonal.model.dtos.EmployeeDTO;
import com.example.controlDePersonal.services.interfaces.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public EmployeeDTO create(@Valid @RequestBody EmployeeDTO employee){
        return this.employeeService.create(employee);
    }

    @PutMapping("/update/{dni}")
    public void update(@PathVariable String dni,
                       @Valid @RequestBody EmployeeDTO employee){
        this.employeeService.update(dni, employee);
    }

    @DeleteMapping("/delete/{dni}")
    public void  delete(@PathVariable String dni){

        this.employeeService.delete(dni);
    }

    @GetMapping("/get/{dni}")
    public EmployeeDTO get(@PathVariable String dni){

        return this.employeeService.findBy(dni);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAll(){

        return this.employeeService.findAll();
    }

}
