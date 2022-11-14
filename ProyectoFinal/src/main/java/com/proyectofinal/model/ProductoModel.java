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

    @Column
    private Integer stock;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    public String informeNewProd() {
        return String.format("Producto creado:%nID: %s | SKU: %s | Descripción: %s | Stock: %s| Precio Compra: $%s | Precio Venta: $%s | Fecha Alta: %s",
                this.id, this.sku, this.descripcion, this.stock, this.precioCompra, this.precioVenta, this.fechaAlta);
    }

    public String informeProdActualizado() {
        return String.format("Producto de ID %s actualizado:%nSKU: %s | Descripción: %s | Stock: %d | Precio Compra: $%s | Precio Venta: $%s | Fecha Alta: %s",
                this.id, this.sku, this.descripcion, this.stock, this.precioCompra, this.precioVenta, this.fechaAlta);
    }
}
