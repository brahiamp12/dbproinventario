package com.dbproyectoinventario.dbproinventario.repository;

import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductStockTotalRepository extends JpaRepository<ProductStockTotal, Integer> {
    Optional<ProductStockTotal> findByProduct_Id(Integer productId);

}
