package com.dbproyectoinventario.dbproinventario.repository;

import com.dbproyectoinventario.dbproinventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndReference(String name, String reference);

}
