package com.proyectofinal.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "venta")
public class VentaModel
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column
    private double total;

    @ManyToOne
    @Column(name = "cliente_id")
    private int clienteId;

    public VentaModel() { }

    public VentaModel(int id, LocalDate fechaAlta, double total, int clienteId) {
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.total = total;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaModel that = (VentaModel) o;
        return id == that.id && Double.compare(that.total, total) == 0 && clienteId == that.clienteId && fechaAlta.equals(that.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "VentaModel{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", total=" + total +
                ", clienteId=" + clienteId +
                '}';
    }
}
