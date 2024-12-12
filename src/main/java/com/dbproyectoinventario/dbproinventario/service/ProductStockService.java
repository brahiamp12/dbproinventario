package com.dbproyectoinventario.dbproinventario.service;
import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.model.ProductStock;
import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import com.dbproyectoinventario.dbproinventario.repository.ProductRepository;
import com.dbproyectoinventario.dbproinventario.repository.ProductStockRepository;
import com.dbproyectoinventario.dbproinventario.repository.ProductStockTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductStockService {
    @Autowired
    private final ProductStockTotalRepository productStockTotalRepository;
    private final ProductRepository productRepository;
    private final ProductStockRepository productStockRepository;

    public ProductStockService(ProductStockTotalRepository productStockTotalRepository, ProductRepository productRepository, ProductStockRepository productStockRepository) {
        this.productStockTotalRepository = productStockTotalRepository;
        this.productRepository = productRepository;
        this.productStockRepository = productStockRepository;
    }

    public ProductStock insertStock(ProductStock productStock){
        Product product = productRepository.findById(productStock.getProduct().getId())
                .orElseThrow(()->new IllegalStateException("Producto no encontrado"));

        ProductStockTotal productStockTotal = productStockTotalRepository.findByProduct_Id(productStock.getProduct().getId())
                .orElse(null);

        Optional<ProductStock> productStockProduct = productStockRepository.findById(productStock.getProduct().getId());
        if(productStockTotal != null) {
            //ProductStock existingProductStock = productStockProduct.get();
            //Optional<ProductStockTotal> productStockTotal = productStockTotalRepository.findById(productStock.getId());
            if (Objects.equals(productStock.getType(), "Salida")){
                if (productStockTotal.getQuantity() < productStock.getQuantity()){
                    throw new IllegalStateException("No hay suficiente stock para salida");
                }
                productStockTotal.setQuantity(productStockTotal.getQuantity() - productStock.getQuantity());
            }else{
                productStockTotal.setQuantity(productStockTotal.getQuantity() + productStock.getQuantity());
            }

            //productStockTotalRepository.save(productStockTotal);
            //return  productStockRepository.save(productStock);

        }else {
            productStockTotal = new ProductStockTotal();
            productStockTotal.setProduct(product);
            productStockTotal.setQuantity(productStock.getQuantity());

        }
        productStockTotalRepository.save(productStockTotal);
        return productStockRepository.save(productStock);
    }

    public List<ProductStock> getStock(){
        return productStockRepository.findAll();
    }
}
