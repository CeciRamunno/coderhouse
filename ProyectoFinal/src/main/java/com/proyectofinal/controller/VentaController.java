package com.proyectofinal.controller;

import com.proyectofinal.model.VentaModel;
import com.proyectofinal.service.VentaServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/venta")
public class VentaController {
    @Autowired
    private VentaServiceImpl vtaSvc;


    @GetMapping(value = "/getVentaById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getVentaById(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(vtaSvc.findVentaById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/todos")
    public ResponseEntity<List<VentaModel>> findAllVentas()
    {
        return new ResponseEntity<>(vtaSvc.findVentas(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewVta")
    public ResponseEntity<VentaModel> createVta(@RequestBody VentaModel newVta)
    {
        return new ResponseEntity<>(vtaSvc.createVenta(newVta), HttpStatus.OK);
    }
}
