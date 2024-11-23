package com.dbproyectoinventario.dbproinventario.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    private int id;
    private String document;
    private String username;
    private String password;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public Usuario(int id, String document, String username, String password, Employee employee) {
        this.id = id;
        this.document = document;
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
