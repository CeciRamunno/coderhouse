package com.proyectofinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel
{
    @Id
    @GeneratedValue
    private int id;

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

    public DetalleVentaModel() { }

    public DetalleVentaModel(int id, VentaModel idVenta, ProductoModel productosId, int cantidad, double subtotal) {
        this.id = id;
        this.idVenta = idVenta;
        this.productosId = productosId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VentaModel getIdVenta() {
        return idVenta;
    }

    public void VentaModel(VentaModel idVenta) {
        this.idVenta = idVenta;
    }

    public ProductoModel getProductosId() {
        return productosId;
    }

    public void setProductosId(ProductoModel productosId) {
        this.productosId = productosId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleVentaModel that = (DetalleVentaModel) o;
        return id == that.id && idVenta == that.idVenta && productosId == that.productosId && cantidad == that.cantidad && Double.compare(that.subtotal, subtotal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DetalleVentaModel{" +
                "id=" + id +
                ", idVenta=" + idVenta +
                ", productosId=" + productosId +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
