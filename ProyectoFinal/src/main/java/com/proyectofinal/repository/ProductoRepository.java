package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<ProductoModel, Integer>
{
    Optional<ProductoModel> findById(int id);
}
