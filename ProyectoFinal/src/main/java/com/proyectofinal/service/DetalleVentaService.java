package com.proyectofinal.service;

import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DetalleVentaService
{
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public Optional<DetalleVentaModel> findById(int id)
    {
        return detalleVentaRepository.findById(id);
    }

    public List<DetalleVentaModel> findAll()
    {
        return detalleVentaRepository.findAll();
    }

    public DetalleVentaModel nuevoDetalleVta(DetalleVentaModel nuevoDetalleVta)
    {
        return detalleVentaRepository.save(nuevoDetalleVta);
    }

    public DetalleVentaModel update(DetalleVentaModel detalleVtaModif, int id)
    {
        Optional<DetalleVentaModel> detalleVentaBD = this.detalleVentaRepository.findById(id);
        if(detalleVentaBD.isPresent())
        {
            DetalleVentaModel detalleVtaABM = detalleVentaBD.get();

            detalleVtaABM.setId(detalleVtaModif.getId());
            detalleVtaABM.setCantidad(detalleVtaModif.getCantidad());
            detalleVtaABM.setProductosId(detalleVtaModif.getProductosId());
            detalleVtaABM.setSubtotal(detalleVtaModif.getSubtotal());

            return this.detalleVentaRepository.save(detalleVtaABM);
        }
        return null;
    }

    public void deleteById(int id)
    {
        this.detalleVentaRepository.deleteById(id);
    }


}
