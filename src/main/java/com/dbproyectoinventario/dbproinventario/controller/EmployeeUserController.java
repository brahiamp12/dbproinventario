package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.EmployeeUser;
import com.dbproyectoinventario.dbproinventario.service.EmployeeUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeUserController {
    private final EmployeeUserService employeeUserService;

    public EmployeeUserController(EmployeeUserService employeeUserService) {
        this.employeeUserService = employeeUserService;
    }

    @PostMapping("/insert")
    public EmployeeUser insert(@RequestBody EmployeeUser employeeUser) {
        try{
            return employeeUserService.insertEmployee(employeeUser);
        }catch (RuntimeException e){
        throw new RuntimeException("Error insertando empleados", e);
        }
    }

    @GetMapping("/getEmployees")
    public List<EmployeeUser> getEmployees() {
        try{
            return employeeUserService.getEmployees();
        }catch(RuntimeException e){
            throw new RuntimeException("Error obteniendo empleados", e);
        }
    }
}
