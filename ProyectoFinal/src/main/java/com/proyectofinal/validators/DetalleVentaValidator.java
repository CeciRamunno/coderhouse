package com.proyectofinal.validators;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleVentaValidator {
    public void validateId(Long id){
        if(id == null || id < 0)
            throw new IllegalArgumentException("Ingrese un ID válido.");
    }

    public void validateLista(List<DetalleVentaModel> detVta) throws ResourceNotFoundException {
        if(detVta == null || detVta.isEmpty() || detVta.size() == 0)
            throw new ResourceNotFoundException("No existe detalle de ventas para esta VentaId.");
    }

    public void validate(DetalleVentaModel detalle) {
        if (detalle == null)
            throw new IllegalArgumentException("No hay valores para el detalle de venta.");

        if (detalle.getVentaId() == null || detalle.getProductoId() == null)
            throw new IllegalArgumentException("Faltan completar detalles de la venta.");

        if(detalle.getCantidad() < 0)
            throw new IllegalArgumentException("La cantidad informada debe ser un número positivo.");

        // Por si hay que hacer una nota de débito, quizás el monto negativo sea correcto.
        // if(detalle.getSubtotal() < 0)
        // throw new IllegalArgumentException("El subtotal calculado debe ser un número positivo.");
    }
}
