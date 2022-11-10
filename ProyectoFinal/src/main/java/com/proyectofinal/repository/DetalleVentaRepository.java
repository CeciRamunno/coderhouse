package com.proyectofinal.repository;

import com.proyectofinal.model.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Long>
{
//    @Query(value = "Select * from detalle_venta where id i= ?1", nativeQuery = true)
//    public DetalleVentaModel findDetalleVtaById(int id);
//
//    @Query(value = "Select * from detalle_venta", nativeQuery = true)
//    public List<DetalleVentaModel> findDetallesVta();
}
