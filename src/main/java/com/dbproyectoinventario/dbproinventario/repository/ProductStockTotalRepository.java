package com.dbproyectoinventario.dbproinventario.repository;

import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductStockTotalRepository extends JpaRepository<ProductStockTotal, Integer> {
    // List<ProductStockTotal> findByProduct_Id(Integer productId);

}
