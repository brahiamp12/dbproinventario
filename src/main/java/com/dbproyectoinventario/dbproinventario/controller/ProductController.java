package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
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

    @GetMapping("name/{name}")
    public List<Product> getProductNames(@PathVariable String name) {
        try {
            return productService.getProductsByName(name);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting product by name", e);
        }

    }

    @GetMapping("name/{name}reference/{reference}")
    public List<Product> getProductNameyReferences(@PathVariable String name, @PathVariable String reference) {
        try {
            return productService.getProductsByNameAndReference(name, reference);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting product by name and reference", e);
        }
    }
    @GetMapping("reference/{reference}")
    public List<Product> getProductReferences(@PathVariable String reference) {
        try {
            return productService.getProductsByReference(reference);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting product by name and reference", e);
        }
    }

    @DeleteMapping("delete/{id}")
    public Product deleteProduct(@PathVariable Integer id){
        try {
            return productService.deleteProductById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error delete producto", e);
        }
    }

    @PutMapping("update/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Product> UpdateProductParcial(@PathVariable int id, @RequestBody Map<String, Object> cambios){
        Product actualizedProduct = productService.updateProduct(id, cambios);
        return ResponseEntity.ok(actualizedProduct);
    }

}
