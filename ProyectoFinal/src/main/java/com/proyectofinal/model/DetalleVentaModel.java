package com.proyectofinal.model;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaModel idVenta;

    @ManyToOne
    @JoinColumn(name = "productos_id")
    private ProductoModel productosId;

    @Column
    private int cantidad;

    @Column
    private double subtotal;
}
