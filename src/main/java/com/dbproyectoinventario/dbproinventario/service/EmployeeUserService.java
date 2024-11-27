package com.dbproyectoinventario.dbproinventario.service;

import com.dbproyectoinventario.dbproinventario.model.EmployeeUser;
import com.dbproyectoinventario.dbproinventario.repository.EmployeeUserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class EmployeeUserService {
    private EmployeeUserRepository employeeUserRepository;

    public EmployeeUserService(EmployeeUserRepository employeeUserRepository) {
        this.employeeUserRepository = employeeUserRepository;
    }

    public EmployeeUser insertEmployee(EmployeeUser employeeUser){
        try {
            return employeeUserRepository.save(employeeUser);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar el empleado", e);
        }
    }

    public List<EmployeeUser> getEmployees(){
        return employeeUserRepository.findAll();

    }
}
