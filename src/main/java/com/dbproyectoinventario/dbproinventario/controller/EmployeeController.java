package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.Employee;
import com.dbproyectoinventario.dbproinventario.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/insert")
    public Employee insert(@RequestBody Employee employee) {
        try{
            return employeeService.insertEmployee(employee);
        }catch (RuntimeException e){
        throw new RuntimeException("Error insertando empleados", e);
        }
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        try{
            return employeeService.getEmployees();
        }catch(RuntimeException e){
            throw new RuntimeException("Error obteniendo empleados", e);
        }
    }
}
