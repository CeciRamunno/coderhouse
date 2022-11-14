package com.proyectofinal.repository;

import com.proyectofinal.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VentaRepository extends JpaRepository<VentaModel, Long>
{
    /**
     * Para traer las ventas realizadas por un Cliente puntual.
     * @param id: id del cliente.
     * @return la lista de ventas para ese cliente.
     */
    @Query(value = "Select * from Venta where cliente_id = ?1", nativeQuery = true)
    public List<VentaModel> findVentasByClienteId(Long id);
}
