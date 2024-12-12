package com.dbproyectoinventario.dbproinventario.service;

import com.dbproyectoinventario.dbproinventario.model.Product;
import com.dbproyectoinventario.dbproinventario.model.ProductStock;
import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import com.dbproyectoinventario.dbproinventario.repository.ProductRepository;
import com.dbproyectoinventario.dbproinventario.repository.ProductStockRepository;
import com.dbproyectoinventario.dbproinventario.repository.ProductStockTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

//import static com.sun.beans.finder.FieldFinder.findField;
import static org.springframework.data.util.ReflectionUtils.setField;
import static org.springframework.util.ReflectionUtils.findField;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final ProductStockTotalRepository productStockTotalRepository;
    private final ProductStockRepository productStockRepository;

    public ProductService(ProductRepository productRepository, ProductStockTotalRepository productStockTotalRepository, ProductStockRepository productStockRepository) {
        this.productRepository = productRepository;
        this.productStockTotalRepository = productStockTotalRepository;
        this.productStockRepository = productStockRepository;
    }

    public Product insertProduct(Product product) {
        try {
            List<Product> productReference = productRepository.findByReference(product.getReference());
            if (!productReference.isEmpty()){
                throw new RuntimeException("Ya existe un producto con esa referencia");

            }
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

    public List<Product> getProductsByName(String name) {
        try {
            return productRepository.findByName(name);
        }catch (RuntimeException e){
            throw new RuntimeException("Error obteniendo productos por nombre", e);
        }
    }

    public List<Product> getProductsByNameAndReference(String name, String reference){
        try {
            return productRepository.findByNameAndReference(name, reference);
        }catch (RuntimeException e){
            throw new RuntimeException("Error obteniendo productos por nombre y referencia", e);
        }
    }

    public List<Product> getProductsByReference(String reference){
        try {
            return productRepository.findByReference(reference);
        }catch (RuntimeException e){
            throw new RuntimeException("Error obteniendo productos por nombre y referencia", e);
        }
    }

    public Product deleteProductById(Integer id){
        List<ProductStock> productStock = productStockRepository.findByProduct_Id(id);

        if (!productStock.isEmpty()){
            throw new RuntimeException("No se puede eliminar el producto, tiene movimientos en stock");

        }
        Optional<Product> id_product = productRepository.findById(id);
        if(id_product.isPresent()){
            productRepository.deleteById(id);
        }
        return null;
    }

    public Product updateProduct(int id, Map<String, Object> cambios){
        Product productExists = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        cambios.forEach((key, value)->{
                    Field field;
                    field = findField(Product.class, key);
                    field.setAccessible(true);
                    setField(field, productExists, value);
                });
        return productRepository.save(productExists);
    }

}
