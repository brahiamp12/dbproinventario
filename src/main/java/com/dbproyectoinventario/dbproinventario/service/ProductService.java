package com.dbproyectoinventario.dbproinventario.service;

import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product insertProduct(Product product) {
        try {
            return productRepository.save(product);
        }catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar producto", e);
        }
    }

    public List<Product> getProducts() {
        try {
           return productRepository.findAll();
        }catch (RuntimeException e){
            throw new RuntimeException("Error obteniendo productos", e);
        }
    }
}
