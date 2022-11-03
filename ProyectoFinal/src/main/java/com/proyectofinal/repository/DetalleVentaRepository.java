package com.proyectofinal.repository;


import com.proyectofinal.model.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Integer>
{
    Optional<DetalleVentaModel> findDetalleVentaById(int id);
}
