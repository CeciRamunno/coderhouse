package com.proyectofinal.service;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl
{
    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<ClienteModel> findClienteById(Long id)
    {
       return this.clienteRepository.findById(id);
    }

    public List<ClienteModel> findClientes()
    {
        return this.clienteRepository.findAll();
    }

    public ClienteModel createCliente(ClienteModel newCliente)
    {
        return clienteRepository.save(newCliente);
    }

    public ClienteModel updateCliente(ClienteModel cliente, Long id)
    {
        Optional<ClienteModel> clienteDB = this.clienteRepository.findById(id);

        if(clienteDB.isPresent())
        {
            ClienteModel clienteABM = clienteDB.get();

            clienteABM.setDni(cliente.getDni());
            clienteABM.setNombre(cliente.getNombre());
            clienteABM.setApellido(cliente.getApellido());
            clienteABM.setFechaNacimiento(cliente.getFechaNacimiento());

            return this.clienteRepository.save(clienteABM);
        }

        return null;
    }

    public void deleteById(long id)
    {
        // TODO VALIDAR SI CLIENTE EXISTE.
        this.clienteRepository.deleteById(id);
    }
}
