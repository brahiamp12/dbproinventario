package com.dbproyectoinventario.dbproinventario.repository;


import com.dbproyectoinventario.dbproinventario.model.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Integer> {
}
