package com.proyectofinal.validators;

import com.proyectofinal.dto.DetalleVentaDto;
import com.proyectofinal.dto.VentaDto;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.VentaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaValidator
{
    public void validate(VentaModel venta)
    {
        if(venta == null)
            throw new IllegalArgumentException("No hay valores en la venta.");

        if(venta.getClienteId() == null)
            throw new IllegalArgumentException("Faltan completar los datos del cliente.");
    }

    public void validateId(Long id)
    {
        if (id == null || id < 0)
            throw new IllegalArgumentException("Ingrese un ID válido.");
    }

    public void validateLista(List<VentaModel> ventas) throws ResourceNotFoundException {
        if(ventas == null || ventas.isEmpty() || ventas.size() == 0)
            throw new ResourceNotFoundException("No hay ventas en la Base de Datos.");
    }

    public void validateDTO(VentaDto vtaDto)
    {
        if(vtaDto == null)
            throw new IllegalArgumentException("No hay datos para la venta.");

        if(vtaDto.getDetalles() == null || vtaDto.getDetalles().size() == 0 || vtaDto.getDetalles().isEmpty() || vtaDto.getIdCliente() < 0)
            throw new IllegalArgumentException("Datos faltantes o mal informados para la venta.");

        for (DetalleVentaDto dvDto : vtaDto.getDetalles())
        {
            if(dvDto == null || dvDto.getCantidad() < 0 || dvDto.getProductoId() < 0)
                throw new IllegalArgumentException("Hay errores en el detalle venta informado.");
        }
    }
}
