package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/insertProduct")
    public Product createProduct(@RequestBody Product product) {
        try{
            return productService.insertProduct(product);
        } catch (RuntimeException e) {
         throw new RuntimeException("Error creating product", e);

        }
    }

    @GetMapping("/getProduct")
    public List<Product> getProducts(){
        try{
            return productService.getProducts();
        }catch (RuntimeException e){
            throw new RuntimeException("Error getting products", e);
        }

    }

}
