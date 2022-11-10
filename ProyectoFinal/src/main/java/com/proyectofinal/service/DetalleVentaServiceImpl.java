package com.proyectofinal.service;

import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImpl
{
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public Optional<DetalleVentaModel> findById(Long id)
    {
        return this.detalleVentaRepository.findById(id);
    }

    public List<DetalleVentaModel> findAll()
    {
        return this.detalleVentaRepository.findAll();
    }

    public DetalleVentaModel createDetalleVenta(DetalleVentaModel newDetalle)
    {
        return this.detalleVentaRepository.save(newDetalle);
    }
}
