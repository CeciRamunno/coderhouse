package com.proyectofinal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "venta")
@NoArgsConstructor
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

    public VentaModel(LocalDate fechaAlta, double total, ClienteModel clienteId)
    {
        this.fechaAlta = fechaAlta;
        this.total = total;
        this.clienteId = clienteId;
    }
}
