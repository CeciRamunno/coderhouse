package com.proyectofinal.repository;

import com.proyectofinal.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long>
{
  /*  Optional<Producto> findById(long dni);
    Optional<Producto> findByNemo(String nemo); */
}
