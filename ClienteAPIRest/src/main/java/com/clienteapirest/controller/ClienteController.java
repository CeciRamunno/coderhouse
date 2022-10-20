package com.clienteapirest.controller;

import com.clienteapirest.model.ClienteModel;
import com.clienteapirest.service.ClienteService;
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

    @GetMapping("/ping")
    public String ping()
    {
        return "pong";
    }

    @GetMapping("/getEdadCliente")
    public ResponseEntity<String> getEdadCliente(@RequestBody ClienteModel cliente)
    {
        return new ResponseEntity<String>(this.clienteSvc.getEdadCliente(cliente), HttpStatus.OK);
    }
}
