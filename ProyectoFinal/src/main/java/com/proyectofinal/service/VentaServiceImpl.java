package com.proyectofinal.service;

import com.proyectofinal.model.VentaModel;
import com.proyectofinal.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl
{
    @Autowired
    private VentaRepository vtaRepository;

    public Optional<VentaModel> findVentaById(Long id)
    {
        return this.vtaRepository.findById(id);
    }

    public List<VentaModel> findVentas()
    {
        return this.vtaRepository.findAll();
    }

    public VentaModel createVenta(VentaModel newVta)
    {
        return this.vtaRepository.save(newVta);
    }

    public VentaModel updateVenta(VentaModel venta, Long id)
    {
        Optional<VentaModel> ventaDB = this.vtaRepository.findById(id);

        if(ventaDB.isPresent())
        {
            VentaModel ventaABM = ventaDB.get();

            ventaABM.setClienteId(venta.getClienteId());
            ventaABM.setDetalle(venta.getDetalle());
            ventaABM.setTotal(venta.getTotal());
            ventaABM.setFechaAlta(venta.getFechaAlta());

            return this.vtaRepository.save(ventaABM);
        }

        return null;
    }
}
