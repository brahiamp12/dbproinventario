package com.dbproyectoinventario.dbproinventario.service;

import com.dbproyectoinventario.dbproinventario.model.Employee;
import com.dbproyectoinventario.dbproinventario.repository.EmployeeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee insertEmployee(Employee employee){
        try {
            return employeeRepository.save(employee);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar el empleado", e);
        }
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();

    }
}
