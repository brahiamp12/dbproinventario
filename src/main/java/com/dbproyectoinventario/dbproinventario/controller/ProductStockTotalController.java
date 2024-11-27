package com.dbproyectoinventario.dbproinventario.controller;

import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import com.dbproyectoinventario.dbproinventario.service.ProductStockTotalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-stock-total")
public class ProductStockTotalController {
    private final ProductStockTotalService productStockTotalService;

    public ProductStockTotalController(ProductStockTotalService productStockTotalService) {
        this.productStockTotalService = productStockTotalService;
    }

    @PostMapping
    public ProductStockTotal insertProductStockTotal(@RequestBody ProductStockTotal productStockTotal) {
        try {
            return productStockTotalService.insertStockTotal(productStockTotal);  // insertando el inventario en la base de datos  // Se utiliza el método insertProductStockTotal de ProductStockTotalService para insertar el inventario en la base de datos.  // Si se produce una excepción, se lanza una RuntimeException con un mensaje personalizado.  // Este método se encuentra en el ProductStockTotalService.java.  // Este método utiliza la anotación @PostMapping para que se pueda recibir peticiones POST con el cuerpo en formato JSON y devuelva el inventario insertado.  // El cuerpo de la petición se pasa como un objeto ProductStockTotal en el parámetro @RequestBody.  // Este método devuelve el inventario insertado.  // Este método también utiliza la anotación @RestController para que esta clase sea un controlador RESTful.
        } catch (RuntimeException e) {
            throw new RuntimeException("Error insertando Inventario", e);
        }
    }

    @GetMapping
    public List<ProductStockTotal> getAllProductStockTotal() {
        try {
            return productStockTotalService.getTotalStock();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error");

        }

    }
}
