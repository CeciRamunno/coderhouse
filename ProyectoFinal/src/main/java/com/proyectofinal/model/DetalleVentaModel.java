package com.proyectofinal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
@NoArgsConstructor
public class DetalleVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaModel ventaId;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel productoId;

    @Column
    private int cantidad;

    @Column
    private double subtotal;

    public DetalleVentaModel(VentaModel ventaId, ProductoModel productoId, int cantidad, double subtotal) {
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
}
