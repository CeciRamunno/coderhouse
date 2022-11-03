package com.proyectofinal.service;

import com.proyectofinal.model.VentaModel;
import com.proyectofinal.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService
{
    @Autowired
    private VentaRepository ventaRepository;

    public Optional<VentaModel> findById(int id)
    {
        return ventaRepository.findById(id);
    }

    public List<VentaModel> findAll()
    {
        return ventaRepository.findAll();
    }

    public VentaModel nuevaVenta(VentaModel nuevaVta)
    {
        return ventaRepository.save(nuevaVta);
    }

    public VentaModel update(VentaModel modifVta, int id)
    {
        Optional<VentaModel> ventaBD = ventaRepository.findById(id);
        if(ventaBD.isPresent())
        {
            VentaModel ventaABM = ventaBD.get();

            ventaABM.setId(modifVta.getId());
            ventaABM.setClienteId(modifVta.getClienteId());
            ventaABM.setFechaAlta(modifVta.getFechaAlta());
            ventaABM.setTotal(modifVta.getTotal());

            return ventaRepository.save(ventaABM);
        }
        return null;
    }
}
