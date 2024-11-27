package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        try{
            return productService.insertProduct(product);
        } catch (RuntimeException e) {
         throw new RuntimeException("Error creating product", e);

        }
    }

    @GetMapping
    public List<Product> getProducts(){
        try{
            return productService.getProducts();
        }catch (RuntimeException e){
            throw new RuntimeException("Error getting products", e);
        }

    }

}
