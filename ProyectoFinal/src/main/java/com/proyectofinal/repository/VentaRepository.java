package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentaRepository extends JpaRepository<VentaModel, Integer>
{

}
