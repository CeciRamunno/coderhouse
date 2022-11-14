package com.proyectofinal.validators;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ClienteModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteValidator {
    public void validate(ClienteModel cliente) {
        if (cliente == null)
            throw new IllegalArgumentException("No hay valores en Cliente.");

        if (cliente.getDni().isBlank() || cliente.getNombre().isBlank() || cliente.getApellido().isBlank())
            throw new IllegalArgumentException("Faltan completar datos del cliente.");
    }

    public void validateId(Long id) {
        if (id == null || id < 0)
            throw new IllegalArgumentException("Ingrese un ID válido.");
    }

    public void validateByDNI(ClienteModel cliente) throws ResourceNotFoundException {
        if (cliente == null)
            throw new ResourceNotFoundException("No existe un cliente con ese DNI.");
    }

    public void validateLista(List<ClienteModel> clientes) throws ResourceNotFoundException {
        if (clientes == null || clientes.isEmpty() || clientes.size() == 0)
            throw new ResourceNotFoundException("No hay clientes cargados en la BD");
    }
}
