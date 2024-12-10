package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.ProductStock;
import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import com.dbproyectoinventario.dbproinventario.service.ProductStockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-stock")
@CrossOrigin(origins = "*")
public class ProductStockController {

    private final ProductStockService productStockService;

    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    @PostMapping
    public ProductStock insertProductStock(@RequestBody ProductStock productStock) {
        try {
            return productStockService.insertStock(productStock);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error insertando Historial de Inventario", e);
        }
    }

    @GetMapping
    public List<ProductStock> getAllProductStock() {
        try {
            return productStockService.getStock();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error");

        }

    }


}
