package com.proyectofinal.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto
{
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NEMO_PRODUCTO")
    private String nemo;

    @Column(name = "DESCRIPCION_PRODUCTO")
    private String descripcion;

    @Column(name = "PRECIO")
    private double precio;
}
