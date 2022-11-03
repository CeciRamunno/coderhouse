package com.proyectofinal.repository;

import com.proyectofinal.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<VentaModel, Integer>
{
    Optional<VentaModel> findProductoById(int id);
}
