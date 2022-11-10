package com.proyectofinal.repository;

import com.proyectofinal.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoModel, Long>
{
    @Query(value = "Select * from productos where id = ?1", nativeQuery = true)
    public ProductoModel findProductoById(long id);
//
//    @Query(value = "Select * from productos", nativeQuery = true)
//    public List<ProductoModel> findAllProductos();
}
