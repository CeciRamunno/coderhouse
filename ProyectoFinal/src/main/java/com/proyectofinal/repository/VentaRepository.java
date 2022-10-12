package com.proyectofinal.repository;

import com.proyectofinal.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface VentaRepository extends JpaRepository<Venta, Long>
{
   /* Optional<Venta> findByProducto(long idProd);
    Optional<Venta> findByCliente(long idCliente);
    Optional<Venta> findByPeriodo(Date desde, Date hasta);
    Optional<Venta> findByFecha(Date fecha); */
}
