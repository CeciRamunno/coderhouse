package com.proyectofinal.repository;

import com.proyectofinal.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer>
{
    Optional<ProductoModel> findProductoById(int id);

    Optional<ProductoModel> findBySku(String sku);
}
