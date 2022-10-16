package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.model.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Integer>
{

}
