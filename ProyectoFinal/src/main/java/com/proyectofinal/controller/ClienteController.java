package com.proyectofinal.controller;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/cliente")
@RestController
public class ClienteController
{
    @Autowired
    private ClienteService clienteSvc;

    @GetMapping("/getClientesById")
    public Optional<ClienteModel> findById(int id)
    {
        return clienteSvc.findById(id);
    }

    @GetMapping("/getClientes")
    public ResponseEntity<List<ClienteModel>> findAll()
    {
        return new ResponseEntity<>(this.clienteSvc.findAll(), HttpStatus.OK);
    }

    @PostMapping("/postAltaCliente")
    public ResponseEntity<ClienteModel> altaCliente(@RequestBody ClienteModel nuevoCliente)
    {
        return new ResponseEntity<>(this.clienteSvc.altaCliente(nuevoCliente), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@RequestBody ClienteModel clienteModif, @PathVariable int id)
    {
        return new ResponseEntity<>(clienteSvc.update(clienteModif, id), HttpStatus.OK);
    }

}
