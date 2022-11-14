package com.proyectofinal.dto;

import lombok.Data;

import java.util.List;

@Data
public class VentaDto {
    private final long idCliente;
    private final List<DetalleVentaDto> detalles;
}
