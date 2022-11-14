package com.proyectofinal.repository;

import com.proyectofinal.model.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Long>
{
    @Query(value = "select * from detalle_venta where venta_id = ?1", nativeQuery = true)
    public List<DetalleVentaModel> findDetalleByVtaId(long id);

    /**
     * Para traer los detalles de ventas realizadas por producto.
     * @param id: id del producto.
     * @return la lista de los detalles de venta para un producto puntual.
     */
    @Query(value = "Select * from detalle_venta where producto_id = ?1", nativeQuery = true)
    public List<DetalleVentaModel> findDetallesByProdId(Long id);
}
