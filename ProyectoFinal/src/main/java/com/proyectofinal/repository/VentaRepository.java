package com.proyectofinal.repository;

import com.proyectofinal.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VentaRepository extends JpaRepository<VentaModel, Long>
{
//    @Query(value = "Select * from venta where id i= ?1", nativeQuery = true)
//    public VentaModel findVentaById(int id);
//
//    @Query(value = "Select * from venta", nativeQuery = true)
//    public List<VentaModel> findAllVentas();
}
