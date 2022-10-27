package com.proyectofinal.service;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<ClienteModel> findById(int id)
    {
        return this.clienteRepository.findById(id);
    }

    public List<ClienteModel> findAll()
    {
        return this.clienteRepository.findAll();
    }

    public ClienteModel altaCliente(ClienteModel nuevoCliente)
    {
        return this.clienteRepository.save(nuevoCliente);
    }

    public ClienteModel update(ClienteModel cliente, int id)
    {
        Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
        if(clienteBD.isPresent())
        {
            ClienteModel clienteABM = clienteBD.get();

            clienteABM.setDni(cliente.getDni());
            clienteABM.setNombre(cliente.getNombre());
            clienteABM.setApellido(cliente.getApellido());
            clienteABM.setFechaNacimiento(cliente.getFechaNacimiento());

            return this.clienteRepository.save(clienteABM);
        }
        return null;
    }

    public void deleteById(int id)
    {
        this.clienteRepository.deleteById(id);
    }

}
