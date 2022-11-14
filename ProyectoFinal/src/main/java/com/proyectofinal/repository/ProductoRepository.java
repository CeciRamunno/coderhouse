package com.proyectofinal.repository;

import com.proyectofinal.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<ProductoModel, Long>
{
    @Query(value = "select * from productos where sku = ?1 and stock > 0", nativeQuery = true)
    public ProductoModel findProductoBySku(String sku);
}
