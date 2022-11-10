package com.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "venta")
public class VentaModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel clienteId;

    @OneToMany
    private List<DetalleVentaModel> detalle;
}
