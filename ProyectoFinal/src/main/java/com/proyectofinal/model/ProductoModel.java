package com.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "productos")
public class ProductoModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String sku;

    @Column
    private String descripcion;

    @Column(name = "precio_compra")
    private double precioCompra;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
}
