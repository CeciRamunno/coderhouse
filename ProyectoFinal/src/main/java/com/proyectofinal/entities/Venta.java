package com.proyectofinal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "VENTAS")
public class Venta
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private long idProducto;

    @Column(name = "CANTIDAD_PRODUCTO")
    private int cantProd;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private long idCliente;

    @Column(name = "TOTAL_VENTA")
    private double totalVenta;

    @Column(name = "FECHA_VENTA")
    private Date fechaVenta;
}
