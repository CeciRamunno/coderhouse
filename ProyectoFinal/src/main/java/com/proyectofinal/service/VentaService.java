package com.proyectofinal.service;

import com.proyectofinal.dto.VentaDto;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.model.VentaModel;

import java.util.List;
import java.util.Optional;

public interface VentaService
{
    public Optional<VentaModel> findVentaById(Long id) throws ResourceNotFoundException;
    public List<DetalleVentaModel> findVentaConDetalleById(Long vtaId) throws ResourceNotFoundException;
    public List<VentaModel> findVentas() throws ResourceNotFoundException;
    public List<VentaModel> findVentasByClienteId(Long idCliente) throws ResourceNotFoundException;
    public VentaModel createVenta(VentaDto newVentaDto) throws ResourceNotFoundException;
    public VentaModel updateVenta(VentaModel venta, Long id) throws ResourceNotFoundException;
}
