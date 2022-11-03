package com.proyectofinal.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class ProductoModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String sku;

    @Column
    private String descripcion;

    @Column
    private double precioCompra;

    @Column
    private double precioVenta;

    @Column
    private int stock;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    public ProductoModel() { }

    public ProductoModel(int id, String sku, String descripcion, double precioCompra, double precioVenta, int stock, LocalDate fechaAlta) {
        this.id = id;
        this.sku = sku;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fechaAlta = fechaAlta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoModel that = (ProductoModel) o;
        return id == that.id && Double.compare(that.precioCompra, precioCompra) == 0 && Double.compare(that.precioVenta, precioVenta) == 0 && stock == that.stock && sku.equals(that.sku) && Objects.equals(descripcion, that.descripcion) && fechaAlta.equals(that.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductoModel{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
