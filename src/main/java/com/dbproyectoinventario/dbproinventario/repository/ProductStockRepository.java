package com.dbproyectoinventario.dbproinventario.repository;
import com.dbproyectoinventario.dbproinventario.model.ProductStock;
import com.dbproyectoinventario.dbproinventario.model.ProductStockTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
    List<ProductStock> findByProduct_Id(Integer productId);


}
