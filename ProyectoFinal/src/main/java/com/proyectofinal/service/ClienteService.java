package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface ClienteService
{
    public Optional<ClienteModel> findClienteById(Long id) throws ResourceNotFoundException;
    public ClienteModel findClienteByDNI(String dni) throws ResourceNotFoundException;
    public List<ClienteModel> findClientes() throws ResourceNotFoundException;
    public String createCliente(ClienteModel newCliente) throws ResourceAlreadyExistsException;
    public String updateCliente(ClienteModel cliente, Long id) throws ResourceNotFoundException;
    public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException;
}
