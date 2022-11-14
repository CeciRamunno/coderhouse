package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;

import java.util.List;

public interface DetalleVentaService
{
    public DetalleVentaModel findById(Long id) throws ResourceNotFoundException;
    public List<DetalleVentaModel> findDetallesByVtaId(Long vtaId) throws ResourceNotFoundException;
    public List<DetalleVentaModel> findAll() throws ResourceNotFoundException;
    public DetalleVentaModel createDetalleVenta(DetalleVentaModel newDetalle);
}
