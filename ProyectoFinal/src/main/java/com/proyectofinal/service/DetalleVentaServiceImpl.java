package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.repository.DetalleVentaRepository;
import com.proyectofinal.validators.DetalleVentaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService
{
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private DetalleVentaValidator detalleVentaValidator;

    @Override
    public DetalleVentaModel findById(Long id) throws ResourceNotFoundException {
        this.detalleVentaValidator.validateId(id);

        Optional<DetalleVentaModel> detVta = this.detalleVentaRepository.findById(id);
        if(detVta.isPresent())
            return detVta.get();
        else
            throw new ResourceNotFoundException("No hay detalle de venta para el ID " + id + ".");
    }

    @Override
    public List<DetalleVentaModel> findDetallesByVtaId(Long vtaId) throws ResourceNotFoundException {
        List<DetalleVentaModel> detVta = this.detalleVentaRepository.findDetalleByVtaId(vtaId);
        this.detalleVentaValidator.validateLista(detVta);

        return detVta;
    }

    @Override
    public List<DetalleVentaModel> findAll() throws ResourceNotFoundException {
        List<DetalleVentaModel> detalles = this.detalleVentaRepository.findAll();
        this.detalleVentaValidator.validateLista(detalles);
        return detalles;
    }

    @Override
    public DetalleVentaModel createDetalleVenta(DetalleVentaModel newDetalle)
    {
        // Valido los detalles de venta ingresados.
        // No valido que no exista en la BD, puesto que puede repetirse la misma venta.
        this.detalleVentaValidator.validate(newDetalle);

        return this.detalleVentaRepository.save(newDetalle);
    }

    // No se considera situación de update y delete para casos de Venta.
    //  (si se diera el caso, debería volverse a generar una venta como nota de deb/créd, según corresponda).
}
