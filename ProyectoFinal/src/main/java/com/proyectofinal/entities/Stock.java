package com.proyectofinal.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "STOCK")
public class Stock
{
    @Id
    @OneToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private int idProducto;

    @Column(name = "STOCK")
    private Long stock;
}
