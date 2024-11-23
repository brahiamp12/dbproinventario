package com.dbproyectoinventario.dbproinventario.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private int quantity;
    private LocalDate create_date;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public ProductStock(int id, Employee employee, String type, int quantity, LocalDate create_date, Product product) {
        this.id = id;
        this.employee = employee;
        this.type = type;
        this.quantity = quantity;
        this.create_date = create_date;
        this.product = product;
    }

    public ProductStock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
