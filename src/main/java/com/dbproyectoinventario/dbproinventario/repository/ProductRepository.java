package com.dbproyectoinventario.dbproinventario.repository;

import com.dbproyectoinventario.dbproinventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
