package com.proyectofinal.controller;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/cliente")
@RestController
public class ClienteController
{
    @Autowired
    private ClienteService clienteSvc;

    @PostMapping("/postAltaCliente")
    public ResponseEntity<ClienteModel> altaCliente(@RequestBody ClienteModel nuevoCliente)
    {
        return new ResponseEntity<>(this.clienteSvc.altaCliente(nuevoCliente), HttpStatus.OK);
    }

    @GetMapping("/getClientes")
    public ResponseEntity<ClienteModel> findAll()
    {
        return new ResponseEntity<ClienteModel>(this.clienteSvc.findAll(), HttpStatus.OK);
    }
}
