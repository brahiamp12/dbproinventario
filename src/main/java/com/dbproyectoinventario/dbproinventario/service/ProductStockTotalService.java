package com.dbproyectoinventario.dbproinventario.service;

import com.dbproyectoinventario.dbproinventario.controller.ProductStockTotalController;
import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import com.dbproyectoinventario.dbproinventario.repository.ProductRepository;
import com.dbproyectoinventario.dbproinventario.repository.ProductStockTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductStockTotalService {
    @Autowired
    private final ProductStockTotalRepository productStockTotalRepository;
    private final ProductRepository productRepository;


    // Method to calculate the total stock of all products in the inventory


    public ProductStockTotalService(ProductStockTotalRepository productStockTotalRepository, ProductRepository productRepository) {
        this.productStockTotalRepository = productStockTotalRepository;
        this.productRepository = productRepository;
    }


    public ProductStockTotal insertStockTotal(ProductStockTotal productStockTotal){
        Product product = productRepository.findById(productStockTotal.getProduct().getId())
                .orElseThrow(()->new IllegalStateException("Producto no encontrado"));

        Optional<ProductStockTotal> productStockTotalProduct = productStockTotalRepository.findById(productStockTotal.getProduct().getId());
        if(productStockTotalProduct.isPresent()) {
            return null;

        }

        return productStockTotalRepository.save(productStockTotal);
    }

    public List<ProductStockTotal> getTotalStock(){
        return productStockTotalRepository.findAll();
    }


}
